package com.william.service.unauthenticate;

import org.apache.log4j.Logger;

import com.william.to.LoginResult;
import com.william.to.LogoutResult;
import com.william.to.User;
import com.william.util.JedisUtil;

public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public LoginResult login(User cto)
	{
		logger.info("Excute LoginService print method ");

		
		LoginResult result = new LoginResult();
		result.setStatus("Y");
		result.setUserid(cto.getUsername());
		return result;
	}
}
