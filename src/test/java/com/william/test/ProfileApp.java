package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileReadDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class ProfileApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		boolean registerStatus=false;
//		boolean loginStatus = false;
//		Date currentTime = new Date();
		LoginResultOutDTO loginResultOutDTO = new LoginResultOutDTO();
		
	    ProfileEntity profileEntity = new ProfileEntity();		
	    
//        RegisterInDTO registerInDTO = new RegisterInDTO("4@gmail.com","MYPasswordMYPasswordMYPasswordMYPassword","Paper Tiger","中国","河南","郑州","新加坡","马林百列","东海岸","1.1","1.2");
//		RegisterOutDTO registerOutDTO = new RegisterOutDTO();
		
		ProfileInDTO profileInDTO = new ProfileInDTO("6855f322fc284d4f9e36465697c11881","1@gmail.com", "MyPassword","胡总","男","04/09/1987","true","北","上","广","深","庆","都","3.1","3.2","约吗？Yes！我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어!");
		
		ProfileDAO MP = new ProfileDAO();
		
//		registerOutDTO = MP.addProfile(registerInDTO);
//		System.out.println(registerOutDTO.getRegisterStatus());	
		
//		registerStatus = MP.updateProfile(profileInDTO);
//		System.out.println(registerStatus);
//		
//		loginResultOutDTO = MP.authenticateCredential("1@gmail.com","MyPassword");
//		System.out.println(loginResultOutDTO.getStatus());		
		
		profileEntity = MP.readProfile("1@gmail.com");
		System.out.println(profileEntity.getNickname());	
		System.out.println(profileEntity.getGender());	
		System.out.println(profileEntity.getCountry());	
		System.out.println(profileEntity.getProvince());
		System.out.println(profileEntity.getCity());
		System.out.println(profileEntity.getCreateTime());
		System.out.println(profileEntity.getSignature());	
		
		
	}

}
