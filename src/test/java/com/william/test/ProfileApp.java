package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileReadDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class ProfileApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		boolean registerStatus=false;
		boolean loginStatus = false;
//		Date currentTime = new Date();
		
	    ProfileEntity profileEntity = new ProfileEntity();		
	    
        RegisterInDTO registerInDTO = new RegisterInDTO("1@gmail.com","MyPassword","HelloKitty","China","Henan","PingDingShan");
		RegisterOutDTO registerOutDTO = new RegisterOutDTO();
		
		ProfileInDTO profileInDTO = new ProfileInDTO("822d5d87885d4c07a183cc247b7913b2","", "MyPassword","","F",
				"13/5/2016","","","","Wonder Wonder Land!");
		
		ProfileDAO MP = new ProfileDAO();
		
//		registerOutDTO = MP.addProfile(registerInDTO);
//		System.out.println(registerOutDTO.getRegisterStatus());	
		
		registerStatus = MP.updateProfile(profileInDTO);
		System.out.println(registerStatus);
		
//		loginStatus = MP.AuthenticateCredential("333@gmail.com","MyPassword");
//		System.out.println(loginStatus);		
		
//		profileEntity = MP.readProfile("666@gmail.com");
//		System.out.println(profileEntity.getCountry());	
//		System.out.println(profileEntity.getProvince());
//		System.out.println(profileEntity.getCity());
//		System.out.println(profileEntity.getCreateTime());	
		
		
	}

}
