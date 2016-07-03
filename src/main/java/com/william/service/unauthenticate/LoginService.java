package com.william.service.unauthenticate;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.to.LoginResultInDTO;
import com.william.to.LoginResultOutDTO;
import com.william.to.ResetPwdInDTO;
import com.william.vo.CommonVO;

public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public LoginResultOutDTO login(LoginResultInDTO cto)
	{
		logger.info("Excute LoginService print method ");

		
		 //= new LoginResultOutDTO();
		ProfileDAO mgDAO = new ProfileDAO();
		//inDTO.setProvince(inDTO.getCity().substring(0, 1));
		LoginResultOutDTO result = mgDAO.authenticateCredential(cto.getUsername(), cto.getPassword());
		
		return result;
	}
	
	public void resetPassword(ResetPwdInDTO input){
		
	}
	
	public CommonVO askForOTP(String email){
		return null;
		
		
	}
}
