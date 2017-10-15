package com.william.service.authenticate;
//Date Validation is Done
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.CredentailInDTO;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileUpdateDTO;
import com.william.util.CryptWithMD5Util;
import com.william.util.ERRORCode;
import com.william.util.FieldPassFilterUtil;
import com.william.util.JedisUtil;
import com.william.vo.CommonInput;
import com.william.vo.CommonVO;


public class LoginService {
	
	private final Logger logger =  Logger.getLogger(this.getClass());
	
	public CommonVO logout(CommonInput input){
		String id = input.getUserIntID();
		logger.info("Excute Logout print method ");
		CommonVO result = new CommonVO();
		result.setStatus("N");
		result.setUserid(id);
		boolean flag = JedisUtil.del(id);
		if(flag)
			result.setStatus("Y");
		return result;
	}
	
	public LoginResultOutDTO loginViaCookie (CommonInput input){

		logger.info("Excute loginViaCookie print method ");
		 //= new LoginResultOutDTO();
		ProfileDAO mgDAO = ProfileDAO.getInstance();
		ProfileEntity profileEntity = mgDAO.readProfileByID(input.getLoginuserid());
		LoginResultOutDTO result = new LoginResultOutDTO();
		if(profileEntity==null){
			result.setStatus("N");
			result.setReason("UserID does not exist");
		} else {
			if(profileEntity.getWrongTryPWD()>4){
				result.setStatus("N");
				result.setReason(ERRORCode.exceedLoginMaxTrial);
			}else if(profileEntity.getWrongTryOTP()<5){
				result.setUsername(profileEntity.getEmail());
				result.setUserid(profileEntity.getUserIntID());
				result.setNickname(profileEntity.getNickname());
				result.setSessionID(input.getSessionID());
				result.setStatus("Y");
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
	
	public CommonVO changePassword(CredentailInDTO credential){
		ProfileDAO mgDAO = new ProfileDAO();
		CommonVO output = new CommonVO();
		if(!FieldPassFilterUtil.validPasswordLength(credential.getPassword0())){
			output.setStatus("N");
			return output;
		}
		
		LoginResultOutDTO result = mgDAO.authenticateCredential(credential.getUsername(), credential.getOldPassword());
		if(result!=null && "Y".equals(result.getStatus())){
			ProfileUpdateDTO profileTo = new ProfileUpdateDTO();
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
