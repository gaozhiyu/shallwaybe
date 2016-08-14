package com.william.service.unauthenticate;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultInDTO;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileUpdateResultDTO;
import com.william.to.ResetPwdInDTO;
import com.william.util.CryptWithMD5Util;
import com.william.util.ERRORCode;
import com.william.vo.CommonVO;

public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public LoginResultOutDTO login(LoginResultInDTO cto)
	{
		logger.info("Excute LoginService print method ");
		 //= new LoginResultOutDTO();
		ProfileDAO mgDAO = ProfileDAO.getInstance();
		ProfileEntity profileEntity = mgDAO.readProfile(cto.getUsername());
		LoginResultOutDTO result = new LoginResultOutDTO();
		if(profileEntity==null){
			result.setStatus("N");
			result.setReason("UserID does not exist");
		} else {
			if(profileEntity.getWrongTryPWD()>4){
				result.setStatus("N");
				result.setReason(ERRORCode.exceedLoginMaxTrial);
			}else if(CryptWithMD5Util.cryptWithMD5Util(cto.getPassword()).equals(profileEntity.getPassword()) && profileEntity.getWrongTryOTP()<5){
				result.setUsername(profileEntity.getEmail());
				result.setUserid(profileEntity.getUserIntID());
				result.setNickname(profileEntity.getNickname());
				result.setStatus("Y");
				if(profileEntity.getWrongTryPWD()!=0){
					try {
						ProfileInDTO profileTo = new ProfileInDTO();
						profileTo.setUserIntID(profileEntity.getUserIntID());
						profileTo.setWrongTryPWD("0");
						mgDAO.updateProfile(profileTo);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				ProfileInDTO profileTo = new ProfileInDTO();
				profileTo.setUserIntID(profileEntity.getUserIntID());
				profileTo.setWrongTryPWD(profileEntity.getWrongTryPWD()+1+"");
				result.setStatus("N");
				try {
					mgDAO.updateProfile(profileTo);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public CommonVO resetPassword(ResetPwdInDTO input){
		ProfileDAO mgDAO = ProfileDAO.getInstance();
		ProfileEntity profileEnity = mgDAO.readProfile(input.getUsername());
		CommonVO cvo = new CommonVO();
		if(profileEnity.getWrongTryOTP()<5 && profileEnity.getOTP().equals(CryptWithMD5Util.cryptWithMD5Util(input.getOtp())) && profileEnity.getOTPExpiryTime().after(new Date())){
			ProfileInDTO profileTo = new ProfileInDTO();
			if(profileEnity.getWrongTryOTP()!=0){
				profileTo.setWrongTryOTP("5");
			}
			if(profileEnity.getWrongTryPWD()!=0){
				profileTo.setWrongTryPWD("0");
			}
			profileTo.setUserIntID(profileEnity.getUserIntID());
			profileTo.setPassword(input.getNewPassword());
			cvo.setStatus("Y");
			try {
				mgDAO.updateProfile(profileTo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(profileEnity.getWrongTryOTP() > 4){
			try {
					ProfileInDTO profileTo = new ProfileInDTO();
					profileTo.setWrongTryOTP(profileEnity.getWrongTryOTP()+1+"");
					profileTo.setUserIntID(profileEnity.getUserIntID());
					cvo.setStatus("F");
					mgDAO.updateProfile(profileTo);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				cvo.setStatus("F");
		}
		
		return cvo;
	}
	
	public CommonVO askForOTP(String email){
		CommonVO cvo = new CommonVO();
		ProfileUpdateResultDTO resultDTO = new ProfileUpdateResultDTO();
		ProfileDAO mgDAO = ProfileDAO.getInstance();
		try {
			//Add otp validation
			ProfileEntity profileEnity = mgDAO.readProfile(email);
			if(profileEnity.getOTPExpiryTime().getTime()-new Date().getTime() > 86100*1000 || profileEnity.getWrongTryOTP()<5 ){//TODO
				ProfileInDTO profileTo = new ProfileInDTO();
				profileTo.setUserIntID(profileEnity.getUserIntID());
				String oTP =CryptWithMD5Util.testRandomNumber(6);//"111111";//TODO later
				profileTo.setOTP(oTP);
				resultDTO = mgDAO.updateProfile(profileTo);
			} else {
				cvo.setReason("Please do so after 24 hours");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultDTO.isProfileUpdate())
			cvo.setStatus("Y");
		else 
			cvo.setStatus("N");
		return cvo;
		
	}
}
