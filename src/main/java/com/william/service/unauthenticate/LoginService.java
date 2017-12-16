package com.william.service.unauthenticate;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.constant.NameConstants;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultInDTO;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileUpdateDTO;
import com.william.to.ProfileUpdateResultDTO;
import com.william.to.ResetPwdInDTO;
import com.william.util.CryptWithMD5Util;
import com.william.util.ERRORCode;
import com.william.util.EmailServiceUtil;
import com.william.util.FieldPassFilterUtil;
import com.william.util.JedisUtil;
import com.william.vo.CommonVO;
import com.william.vo.EmailVO;

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
				if(cto.getRegid()!=null && !"".equals(cto.getRegid()))
					JedisUtil.set(profileEntity.getUserIntID(), NameConstants.REGID, cto.getRegid());
				// Push the notification
				if(profileEntity.getWrongTryPWD()!=0){
					try {
						ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
						profileTo.setUserIntID(profileEntity.getUserIntID());
						profileTo.setWrongTryPWD("0");
						mgDAO.updateProfile(profileTo);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
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
	
//TODO	
	public CommonVO resetPassword(ResetPwdInDTO input){
		ProfileDAO mgDAO = ProfileDAO.getInstance();
		ProfileEntity profileEnity = mgDAO.readProfile(input.getUsername());
		CommonVO cvo = new CommonVO();
		if(!FieldPassFilterUtil.validPasswordLength(input.getNewPassword())){
			cvo.setStatus("N");
			return cvo;
		}
		
		if(profileEnity.getWrongTryOTP()<5 && profileEnity.getOTP().equals(CryptWithMD5Util.cryptWithMD5Util(input.getOtp())) && profileEnity.getOTPExpiryTime().after(new Date())){
			ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
			if(profileEnity.getWrongTryOTP()!=0){
				profileTo.setWrongTryOTP("0");
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
				 	ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
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
			if(profileEnity.getWrongTryOTP()<5 || new Date().getTime() - profileEnity.getOTPExpiryTime().getTime()> 86100*1000  ){//TODO
				ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
				profileTo.setUserIntID(profileEnity.getUserIntID());
				String oTP =CryptWithMD5Util.testRandomNumber(6);//"111111";//TODO later
				EmailVO emailVO = new EmailVO("gaozhiyu301@gmail.com","Please check with OTP from shall-way",oTP);
		    	if(EmailServiceUtil.sendEmail(emailVO)){
					profileTo.setOTP(oTP);
					resultDTO = mgDAO.updateProfile(profileTo);
		    	}
			} else {
				cvo.setReason("Please do so after 24 hours");
			}
		} catch (Exception e) {
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
