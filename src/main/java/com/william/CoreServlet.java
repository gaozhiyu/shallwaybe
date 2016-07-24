package com.william;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.corundumstudio.socketio.protocol.Packet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.DAO.MessageDAO;
import com.william.filter.LogFile;
import com.william.to.LoginResultOutDTO;
import com.william.to.MessageOutDTO;
import com.william.util.ChatMessageQueue;
import com.william.util.JedisUtil;

public class CoreServlet extends HttpServlet {

	private final Logger logger = Logger.getLogger(this.getClass());

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {

			out = response.getWriter();
			ServletInputStream is = request.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(is, baos);
			String utilJson = new String(baos.toByteArray(), "UTF-8");
			HttpSession session = request.getSession(true);

			logger.info(utilJson + "Baby I know you are here" + request.getRequestURI());

			Object returnValue = invokeService(request.getRequestURI(), utilJson, session.getId());

			ObjectMapper mapper = new ObjectMapper();
			String str = "";
			try {
				str = mapper.writeValueAsString(returnValue);
				// TODO make it more specific
				if (request.getRequestURI().equals(request.getContextPath() + "/unauthenticate/LoginService/login")) {
					logger.info("Store the datat to memory");
					LoginResultOutDTO tmp = (LoginResultOutDTO) returnValue;
					if ("Y".equalsIgnoreCase(tmp.getStatus())) {
						logger.info("Userid\t" + tmp.getUserid());
						// Fixme update the logic
						// HttpSession session = request.getSession(true);
						session.setAttribute("userid", tmp.getUserid());
						// String tmpid = (String)
						// session.getAttribute("userid");
						session.setMaxInactiveInterval(-1);

						String sessionId = request.getSession().getId();
						logger.info("Sessionid\t" + sessionId);
						JedisUtil.set(tmp.getUserid(), sessionId);
						// JedisUtil.set(sessionId, tmp.getUserid());//fixme
						// remove this line
						// Logic to logout previous login;
						tmp.setSessionID(sessionId);
						str = mapper.writeValueAsString(tmp);
					}
				}
				// TODO make it more specific
				if (request.getRequestURI().contains("/LoginService/logout")) {
					request.getSession().removeAttribute("userid");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
			System.out.println("Parse from java to Json\t" + str);

			out.write(str);
			out.flush();
			// response.setHeader(arg0, arg1)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object invokeService(String uri, String utilJson, String sessionID) {
		ObjectMapper objectMapper = new ObjectMapper();
		String[] uriArray = uri.split("/");
		Object returnvalue = "";
		StringBuffer servicString = new StringBuffer("com.william.service.");// FIXME
		// recursive go through the folder
		if (uriArray.length > 3) {
			servicString.append(uriArray[2] + ".");
			servicString.append(uriArray[uriArray.length - 2]);
		}
		try {
			System.out.println(servicString.toString());
			Class serviceProvider = Class.forName(servicString.toString());
			Method service[] = serviceProvider.getMethods();
			Method method = null;
			for (int i = 0; i < service.length; i++) {
				if (service[i].getName().equalsIgnoreCase(uriArray[uriArray.length - 1])) {
					method = service[i];
					break;
				}
			}
			Class<?>[] types = method.getParameterTypes();
			if (types.length > 0) {
				Object[] params = new Object[types.length];
				JsonNode tree = objectMapper.readTree(utilJson);
				if (!tree.isArray()) {
					System.out.println("Parameters must in array!");
					throw new IllegalAccessError("Parameters must in array!");
				}
				Iterator<JsonNode> it = tree.iterator();
				int i = 0;
				while (it.hasNext()) {
					JsonNode node = it.next();
					Class<?> type = types[i];
					params[i] = objectMapper.readValue(node.traverse(), type);

					try {
						if (uriArray.length > 3 && "authenticate".equals(uriArray[2])) {
							System.out.println("set seseeion id into DTO");
							Method d = type.getMethod("setSessionID",String.class);
							d.invoke(params[i], sessionID);
						}
					} catch (Exception e) {
						logger.info("There is no setSessionID method");
					}
					if (i < types.length) {
						i++;
					} else {
						break;
					}
				}
				// Method c=cls.getMethod("print", new Class[]{String.class});
				returnvalue = method.invoke(serviceProvider.newInstance(), params);
			} else {
				returnvalue = method.invoke(serviceProvider.newInstance());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Invoke method Failed", e);
		}
		return returnvalue;
	}

	public void init() {

		com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
		config.setHostname("172.23.47.93");
		config.setPort(9092);

		final SocketIOServer server = new SocketIOServer(config);
		// server.addNamespace("/chat");

		server.addEventListener("chatevent", LogFile.class, new DataListener<LogFile>() {
			public void onData(SocketIOClient client, LogFile data, AckRequest ackSender) {
				String uuid = JedisUtil.get(data.getToID(), "chat");
				if (uuid == null || "".equals(uuid)) {
					ChatMessageQueue.getInstance().postMessage(data);
				} else {
					UUID to = UUID.fromString(uuid);
					SocketIOClient toClient = client.getNamespace().getClient(to);

					if (toClient != null)
						toClient.sendEvent("chatevent", data);
				}
			}
		});

		server.addDisconnectListener(new DisconnectListener() {
			public void onDisconnect(SocketIOClient client) {
				// ...

				String key = client.get("id");
				// TODO
				JedisUtil.hdel(key, "chat");

			}
		});

		server.addConnectListener(new ConnectListener() {
			public void onConnect(SocketIOClient client) {
				// TODO this id must be authenicate
				if (1 == 1) {
					HandshakeData data = client.getHandshakeData();
					Map<String, List<String>> map = data.getUrlParams();
					List<String> strList = map.get("foo");
					if (strList != null && strList.size() > 0) {
						String userid = strList.get(0);
						client.set("id", strList.get(0));
						JedisUtil.set(strList.get(0), "chat", client.getSessionId().toString());
						MessageDAO messageDAO = new MessageDAO();
						try {
							MessageOutDTO[] msgArray = messageDAO.retrieveMessage(userid);
							// for(int i= 0; )
							if (msgArray != null && msgArray.length > 0) {
								// LogFile msg = msgArray[i];
								for (int i = 0; i < msgArray.length; i++) {
									LogFile msg = new LogFile();
									msg.setFromID(msgArray[i].getSenderIntID());
									msg.setToID(userid);
									msg.setFromNickname(msgArray[i].getSenderNickname());
									msg.setLine(msgArray[i].getMessageContents());
									client.sendEvent("chatevent", msg);
								}

								for (int i = 0; i < msgArray.length; i++) {
									messageDAO.updateMessageSendStatus(msgArray[i].getMessageID());
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							logger.info("Invoke method Failed", e);
						}
					}
				}
			}
		});

		server.start();
	}
}
