package com.william.test;

import java.text.ParseException;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileUpdateResultDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class TestProfile {
	ProfileEntity profileEntity = new ProfileEntity();
	ProfileDAO MP = ProfileDAO.getInstance();
	RegisterInDTO registerInDTO = new RegisterInDTO("2@gmail.com","MYPasswordMYPasswordMYPasswordMYPassword","Paper Tiger","中国","河南","郑州","新加坡","马林百列","东海岸","1.1","1.2");
	RegisterOutDTO registerOutDTO = new RegisterOutDTO();
	ProfileInDTO profileInDTO = new ProfileInDTO("8a0e4da44b904eb3887e7ae5354ce12d","1@gmail.com", "MyPassword","胡总","男","04/09/1987","true","1","123456","0","北","上","广","深","庆","都","3.1","3.2","For test only");
//	"约吗？Yes！我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어!"
	boolean updateStatus=false;
	LoginResultOutDTO loginResultOutDTO = new LoginResultOutDTO();
	ProfileUpdateResultDTO profileUpdateResultDTO = new ProfileUpdateResultDTO();

	@Test
	public void testAddProfile(){

		registerOutDTO = MP.addProfile(registerInDTO);
		System.out.println(registerOutDTO.getRegisterStatus());	
	}
	

	@Test
	public void testUpdateProfile() throws ParseException{
		profileEntity = MP.readProfile(registerInDTO.getEmail());
		profileInDTO.setUserIntID(profileEntity.getUserIntID());
		profileUpdateResultDTO = MP.updateProfile(profileInDTO);
		System.out.println("profile updated:"+profileUpdateResultDTO.isProfileUpdate());
				
	}
	

	@Test
	public void testAuthenticateCredential(){
		loginResultOutDTO = MP.authenticateCredential("1@gmail.com","MyPassword");
		System.out.println(loginResultOutDTO.getStatus());	
	}
	

	@Test
	public void testReadProfile(){
		profileEntity = MP.readProfile("1@gmail.com");
		System.out.println(profileEntity.getNickname());	
		System.out.println(profileEntity.getGender());
		System.out.println(profileEntity.getOTPExpiryTime());
		System.out.println(profileEntity.getCountry());	
		System.out.println(profileEntity.getProvince());
		System.out.println(profileEntity.getCity());
		System.out.println(profileEntity.getCreateTime());
		System.out.println(profileEntity.getSignature());
	}
	
	@Test
	public void testReadProfileByID(){
		profileEntity = MP.readProfile(registerInDTO.getEmail());
		profileEntity = MP.readProfileByID(profileEntity.getUserIntID());
		System.out.println(profileEntity.getNickname());	
		System.out.println(profileEntity.getGender());
		System.out.println(profileEntity.getOTPExpiryTime());
		System.out.println(profileEntity.getCountry());	
		System.out.println(profileEntity.getProvince());
		System.out.println(profileEntity.getCity());
		System.out.println(profileEntity.getCreateTime());
		System.out.println(profileEntity.getSignature());
	}
	
	// generate random number to be used as OTP
	@Test
	public void testRandomNumber(){
		
	    final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final int N = alphabet.length();
	    Random r = new Random();
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < 10; i++) {
	    	char newchar = alphabet.charAt(r.nextInt(N));
//	        System.out.print(newchar);
	        sb.append(newchar);
	    }
	    
	    System.out.println("\n New String:" + sb.toString());
	    
//	    return sb.toString();
	}
}