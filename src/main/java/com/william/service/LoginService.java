package com.william.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.to.User;

public class LoginService {
	public String login(User cto)
	{
		System.out.println("Excute LoginService print method ");
		//System.out.println(user.getPassword()+"\t"+user.getPassword());
		ObjectMapper mapper= new ObjectMapper();
		String str="";
		try {
			 str = mapper.writeValueAsString(cto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Parse from java to Json\t"+ str);
		return str;
	}

}
