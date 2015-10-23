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

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

			String returnValue = invokeService(request.getRequestURI(), utilJson);

			// User garima = new ObjectMapper().readValue(utilJson, User.class);
			out.write(returnValue);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String invokeService(String uri, String utilJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		String[] uriArray = uri.split("/");
		String returnvalue="";
		StringBuffer servicString = new StringBuffer("com.william.service.");
		// recursive go through the folder
		if (uriArray.length > 1) {
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
			// Class cls = Class.forName("com.ncs.service.LoginService");
			// Method c=cls.getMethod("print", new Class[]{String.class});
			returnvalue=(String) method.invoke(serviceProvider.newInstance(), params);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnvalue;
	}
}
