package com.william.test;

import java.text.ParseException;

import org.junit.Ignore;
import org.junit.Test;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class TestProfile {
	ProfileEntity profileEntity = new ProfileEntity();
	ProfileDAO MP = ProfileDAO.getInstance();
	RegisterInDTO registerInDTO = new RegisterInDTO("4@gmail.com","MYPasswordMYPasswordMYPasswordMYPassword","Paper Tiger","中国","河南","郑州","新加坡","马林百列","东海岸","1.1","1.2");
	RegisterOutDTO registerOutDTO = new RegisterOutDTO();
	ProfileInDTO profileInDTO = new ProfileInDTO("8a0e4da44b904eb3887e7ae5354ce12d","4@gmail.com", "MyPassword","胡总","男","04/09/1987","true","1","123456","0","北","上","广","深","庆","都","3.1","3.2","约吗？Yes！我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어!");
	boolean updateStatus=false;
	LoginResultOutDTO loginResultOutDTO = new LoginResultOutDTO();
	
	@Ignore
	@Test
	public void testAddProfile(){
		registerOutDTO = MP.addProfile(registerInDTO);
		System.out.println(registerOutDTO.getRegisterStatus());	
	}
	
	@Ignore
	@Test
	public void testUpdateProfile() throws ParseException{
		updateStatus = MP.updateProfile(profileInDTO);
		System.out.println("profile updated:"+updateStatus);
				
	}
	
	@Ignore
	@Test
	public void testAuthenticateCredential(){
		loginResultOutDTO = MP.authenticateCredential("4@gmail.com","MyPassword");
		System.out.println(loginResultOutDTO.getStatus());	
	}
	
	@Test
	public void testReadProfile(){
		profileEntity = MP.readProfile("4@gmail.com");
		System.out.println(profileEntity.getNickname());	
		System.out.println(profileEntity.getGender());
		System.out.println(profileEntity.getOTPExpiryTime());
		System.out.println(profileEntity.getCountry());	
		System.out.println(profileEntity.getProvince());
		System.out.println(profileEntity.getCity());
		System.out.println(profileEntity.getCreateTime());
		System.out.println(profileEntity.getSignature());
	}
	
}