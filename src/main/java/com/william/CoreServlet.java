package com.william;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.to.LoginResult;
import com.william.util.JedisUtil;

public class CoreServlet extends HttpServlet {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			ServletInputStream is = request.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(is, baos);
			String utilJson = new String(baos.toByteArray(), "UTF-8");
			
			logger.info(utilJson + "Baby I know you are here"
					+ request.getRequestURI());

			Object returnValue = invokeService(request.getRequestURI(), utilJson);

			
			ObjectMapper mapper= new ObjectMapper();
			String str="";
			try {
				 str = mapper.writeValueAsString(returnValue);
					if(request.getRequestURI().contains("/LoginService/login")){
						logger.info("Store the datat to memory");
						LoginResult tmp = (LoginResult)returnValue;
						if("Y".equalsIgnoreCase(tmp.getStatus())){
							logger.info("Userid\t"+ tmp.getUserid());
							//Fixme update the logic
							HttpSession session = request.getSession();
							session.setAttribute("userid", tmp.getUserid());
							
							
							String sessionId = request.getSession().getId();
							logger.info("Sessionid\t"+  sessionId);
							JedisUtil.set(tmp.getUserid(), sessionId);
							//JedisUtil.set(sessionId, tmp.getUserid());//fixme remove this line
							//Logic to logout previous login;
							tmp.setSessionID(sessionId);
							str = mapper.writeValueAsString(tmp);
						}
						
						if(request.getRequestURI().contains("/LoginService/logout")){
							request.getSession().removeAttribute("userid");
						}
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
			System.out.println("Parse from java to Json\t"+ str);
			
			out.write(str);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object invokeService(String uri, String utilJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		String[] uriArray = uri.split("/");
		Object returnvalue="";
		StringBuffer servicString = new StringBuffer("com.william.service.");//FIXME
		// recursive go through the folder
		if (uriArray.length > 3) {
			servicString.append(uriArray[2]+".");
			servicString.append(uriArray[uriArray.length - 2]);
		}
		try {
			System.out.println(servicString.toString());
			Class serviceProvider = Class.forName(servicString.toString());
			Method service[] = serviceProvider.getMethods();
			Method method = null;
			for (int i = 0; i < service.length; i++) {
				if (service[i].getName().equalsIgnoreCase(
						uriArray[uriArray.length - 1])) {
					method = service[i];
					break;
				}
			}
			Class<?>[] types = method.getParameterTypes();
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
                            if (i < types.length) {
                                            i++;
                            } else {
                                            break;
                            }
            }
			// Method c=cls.getMethod("print", new Class[]{String.class});
			returnvalue= method.invoke(serviceProvider.newInstance(), params);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnvalue;
	}
}
