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
	    
        RegisterInDTO registerInDTO = new RegisterInDTO("6@gmail.com","MyPassword","User2","China","Henan","PingDingShan");
		RegisterOutDTO registerOutDTO = new RegisterOutDTO();
		
		ProfileInDTO profileInDTO = new ProfileInDTO("675cb7a0802f43358d5e1e6f7c19952b","", "MyPassword","User3","M",
				"13/5/2016","","","","Wonder Wonder Land!");
		
		ProfileDAO MP = new ProfileDAO();
		
//		registerOutDTO = MP.addProfile(registerInDTO);
//		System.out.println(registerOutDTO.getRegisterStatus());	
		
//		registerStatus = MP.updateProfile(profileInDTO);
//		System.out.println(registerStatus);
//		
//		loginResultOutDTO = MP.authenticateCredential("1@gmail.com","MyPassword");
//		System.out.println(loginResultOutDTO.getStatus());		
		
		profileEntity = MP.readProfile("6@gmail.com");
		System.out.println(profileEntity.getCountry());	
		System.out.println(profileEntity.getProvince());
		System.out.println(profileEntity.getCity());
		System.out.println(profileEntity.getCreateTime());	
		
		
	}

}
