package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ProfileDAO;
import com.william.to.ProfileInDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class ProfileApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		boolean registerStatus=false;
		Date currentTime = new Date();
		
        RegisterInDTO registerInDTO = new RegisterInDTO("666@gmail.com","MyPassword","HelloKitty","China","Henan","PingDingShan");
		RegisterOutDTO registerOutDTO = new RegisterOutDTO();
		
		ProfileInDTO profileInDTO = new ProfileInDTO("5a049676f51645eb80c3c37011d4185a","", "MyPassword","","F",
				currentTime,"","","","Hello My World of ShallWay!");
		
		ProfileDAO MP = new ProfileDAO();
//		registerOutDTO = MP.addProfile(registerInDTO);
		registerStatus = MP.updateProfile(profileInDTO);
		
//		System.out.println(registerOutDTO.getRegisterStatus());		
		System.out.println(registerStatus);
		
//		MP.addProfile("666666@gmail.com", "MyPassword", "HelloWord", "M", dateOfBirth, "China", "Henan", lastUpdate, createTime, lastAddressUpdate, "ShallWay? Yes!");
//		this part to be modified 19.3.2016

//		System.out.println(dateOfBirth);
//		System.out.println(lastUpdate);
//		System.out.println(createTime);	
//		System.out.println(lastAddressUpdate);	
	}

}
