package com.william.test;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileUpdateDTO;
import com.william.to.ProfileUpdateResultDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;
import com.william.util.FieldPassFilterUtil;

public class TestProfile {
	Date currentTime = new Date();
	ProfileEntity profileEntity = new ProfileEntity();
	ProfileDAO MP = ProfileDAO.getInstance();
	RegisterInDTO registerInDTO = new RegisterInDTO("4@gmail.com","MYPassword","测试员4","中国","河南","郑州","新加坡","马林百列","东海岸","1.1","1.2");
	RegisterOutDTO registerOutDTO = new RegisterOutDTO();
	ProfileInDTO profileInDTO = new ProfileInDTO("dab4dbe204294a368fc3c30cb7f479a3","4@gmail.com", "MyPassword","胡总","男","04/09/1987",currentTime,"1","123456","0","北","上","广","深","庆","都","179.12345","9.9","For test only");
//	"约吗？Yes！我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어!"
	boolean updateStatus=false;
	LoginResultOutDTO loginResultOutDTO = new LoginResultOutDTO();
	ProfileUpdateResultDTO profileUpdateResultDTO = new ProfileUpdateResultDTO();

	@Test
	public void testAddProfile(){
		System.out.println(FieldPassFilterUtil.validEmailAdreess(registerInDTO.getEmail()));
		registerOutDTO = MP.addProfile(registerInDTO);
		System.out.println(registerOutDTO.getRegisterStatus());	
	}
	

	@Test
	public void testUpdateProfile() throws ParseException{
//		profileEntity = MP.readProfile(registerInDTO.getEmail());
//		profileInDTO.setUserIntID(profileEntity.getUserIntID());
		ProfileUpdateDTO profileUpdateDTO = new ProfileUpdateDTO("dab4dbe204294a368fc3c30cb7f479a3","4@gmail.com", "MyPassword","测试员4","男","05/09/1987",currentTime,"0","123456","0","北","上","广","深","庆","都","179.12345","9.9","For test only");
		profileUpdateResultDTO = MP.updateProfile(profileUpdateDTO);
		System.out.println("profile updated:"+profileUpdateResultDTO.isProfileUpdate());
				
	}
	

	@Test
	public void testAuthenticateCredential(){
		loginResultOutDTO = MP.authenticateCredential("hz21157@gmail.com","MyPassword");
		System.out.println(loginResultOutDTO.getStatus());	
	}
	

	@Test
	public void testReadProfile(){
		profileEntity = MP.readProfile("hz21157@gmail.com");
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
	
	@Test
	public void testInputValidation(){

/*		private String userIntID;
		private String email;
		private String password;
		private String nickname;
		private String gender;
		private String dateOfBirth;
		private String profilePhoto;
		private String wrongTryPWD;
		private String OTP;
		private String wrongTryOTP;
		private String country;
		private String province;
		private String city;
		private String googleCountry;
		private String googleProvince;
		private String googleCity;
		private String longitude; ^[-\+]?((1[0-7]\d{1}|0?\d{1,2})\.\d{1,5}|180\.0{1,5})$
		private String latitude;	^[-\+]?([0-8]?\d{1}\.\d{1,5}|90\.0{1,5})$
		private String signature;
		
*/	
    	String emailString ="^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]?@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	boolean emailMatch = Pattern.matches(emailString, profileInDTO.getEmail());
    	System.out.println("Email Pattern matches?: "+emailMatch);
    	
    	String longitudeString = "^[-|+]?((1[0-7]\\d{1}|0?\\d{1,2})\\.\\d{1,5}|180\\.0{1,5})$";
    	boolean longitudeMatch = Pattern.matches(longitudeString, profileInDTO.getLongitude());
    	System.out.println("Longitude Pattern matches?: "+longitudeMatch);
    	
       	String latitudeString = "^[-|+]?([0-8]?\\d{1}\\.\\d{1,5}|90\\.0{1,5})$";
    	boolean latitudeMatch = Pattern.matches(latitudeString, profileInDTO.getLatitude());
    	System.out.println("Latitude Pattern matches?: "+latitudeMatch);
		
	}
}