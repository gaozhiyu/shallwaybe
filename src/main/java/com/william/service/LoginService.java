package com.william.service;

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

	
	public LogoutResult logout(String id)
	{
		logger.info("Excute Logout print method ");
		LogoutResult result = new LogoutResult();
		result.setStatus("N");
		result.setUserid(id);
		boolean flag = JedisUtil.del(id);
		if(flag)
			result.setStatus("Y");
		return result;
	}
}
