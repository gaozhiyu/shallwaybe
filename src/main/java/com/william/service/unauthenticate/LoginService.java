package com.william.service.unauthenticate;

import org.apache.log4j.Logger;

import com.william.to.LoginResultOutDTO;
import com.william.to.LogoutResultOutDTO;
import com.william.to.UserInDTO;
import com.william.util.JedisUtil;

public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public LoginResultOutDTO login(UserInDTO cto)
	{
		logger.info("Excute LoginService print method ");

		
		LoginResultOutDTO result = new LoginResultOutDTO();
		result.setStatus("Y");
		result.setUserid(cto.getUsername());
		return result;
	}
}
