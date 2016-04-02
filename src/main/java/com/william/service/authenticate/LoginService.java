package com.william.service.authenticate;

import org.apache.log4j.Logger;

import com.william.to.LoginResultOutDTO;
import com.william.to.LogoutResultOutDTO;
import com.william.to.LoginResultInDTO;
import com.william.util.JedisUtil;

public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public LogoutResultOutDTO logout(String id)
	{
		logger.info("Excute Logout print method ");
		LogoutResultOutDTO result = new LogoutResultOutDTO();
		result.setStatus("N");
		result.setUserid(id);
		boolean flag = JedisUtil.del(id);
		if(flag)
			result.setStatus("Y");
		return result;
	}
	
	public void changePassword(){
		
	}
}
