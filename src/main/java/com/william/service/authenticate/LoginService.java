package com.william.service.authenticate;

import org.apache.log4j.Logger;

import com.william.util.JedisUtil;
import com.william.vo.CommonVO;


public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public CommonVO logout(String id)
	{
		logger.info("Excute Logout print method ");
		CommonVO result = new CommonVO();
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
