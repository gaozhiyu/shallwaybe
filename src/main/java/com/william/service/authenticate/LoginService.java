package com.william.service.authenticate;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.to.CredentailInDTO;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
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
	
	public CommonVO changePassword(CredentailInDTO credential){
		ProfileDAO mgDAO = new ProfileDAO();
		CommonVO output = new CommonVO();
		LoginResultOutDTO result = mgDAO.authenticateCredential(credential.getUsername(), credential.getOldPassword());
		if(result!=null && "Y".equals(result.getStatus())){
			ProfileInDTO profileTo = new ProfileInDTO();
			try {
				profileTo.setUserIntID(result.getUserid());
				profileTo.setPassword(credential.getPassword0());
				mgDAO.updateProfile(profileTo);
				output.setStatus("Y");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				output.setStatus("F");
				e.printStackTrace();
			}
		} else {
			output.setStatus("N");
			output.setReason("Incorrect Old password");
			//TODO changeto ERROR code
		}
		
		return output;
	}
}
