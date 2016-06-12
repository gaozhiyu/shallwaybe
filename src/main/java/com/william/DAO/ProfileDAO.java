package com.william.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.ProfileEntity;
import com.william.to.LoginResultOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;
import com.william.util.CryptWithMD5Util;
import com.william.util.HibernateUtil;

public class ProfileDAO {
	
	/*Create Profile Record*/
	public RegisterOutDTO addProfile(RegisterInDTO profileTo){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String userIntID = UUID.randomUUID().toString().replaceAll("-", "");
	      String password = CryptWithMD5Util.cryptWithMD5Util(profileTo.getPassword());
	      ProfileEntity profileEntity = new ProfileEntity();
	      RegisterOutDTO outDto = new RegisterOutDTO();
	      Date registerTime = new Date();
 	      
	      try{
	         tx = session.beginTransaction();
	        // profile = new ProfileEntity(userIntID, email, password, nickName, gender, dateOfBirth,
	     			//country, city, lastUpdate, createTime, lastAddressUpdate, status);
	         profileEntity.setUserIntID(userIntID);
	         profileEntity.setPassword(password);
	         profileEntity.setEmail(profileTo.getEmail());
	         profileEntity.setNickname(profileTo.getNickname());
	         profileEntity.setCountry(profileTo.getCountry());
	         profileEntity.setProvince(profileTo.getProvince());
	         profileEntity.setCity(profileTo.getCity());
	         profileEntity.setGoogleCountry(profileTo.getGoogleCountry());
	         profileEntity.setGoogleProvince(profileTo.getGoogleProvince());
	         profileEntity.setGoogleCity(profileTo.getGoogleCity());
	         profileEntity.setLongitude(Double.parseDouble(profileTo.getLongitude()));
	         profileEntity.setLatitude(Double.parseDouble(profileTo.getLatitude()));
	         profileEntity.setCreateTime(registerTime);
	         profileEntity.setLastUpdate(registerTime);
	         profileEntity.setLastAddressUpdate(registerTime);
	         
               
	         session.save(profileEntity);
	         
	         tx.commit();
	         
	         outDto.setUserIntID(userIntID);
	         outDto.setUserid(profileTo.getEmail()); 
	         outDto.setRegisterStatus("Registration Successful");
	         
	         
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return outDto;
	}
	
	/* to update a profile record*/
	public boolean updateProfile(ProfileInDTO profileTo) throws ParseException
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ProfileEntity profileEntity = new ProfileEntity();
		boolean updateStatus = false;
		Date currentTime = new Date();
		String userIntID = profileTo.getUserIntID();
        SimpleDateFormat dobString =new SimpleDateFormat("dd/MM/yyyy");
        
			
	    try{
		      tx = session.beginTransaction();

//		      String sql = "select * from profile where UserIntID = '"+userIntID+"'";
		      String sql = "select * from profile where UserIntID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, userIntID);
		      query.addEntity(ProfileEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ProfileEntity> profileList = query.list();	
		      
		      /*method 1*/
		      if (profileList!=null && profileList.size()>0)
		    	  profileEntity = profileList.get(0);
	
//		      /*method 2*/
//		      for (ProfileEntity latestcoordinate:profileList){

		      /*method 3*/
//		      LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
     
			 if(profileTo.getCountry()!=null && !"".equals(profileTo.getCountry().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setCountry(profileTo.getCountry());
			 }	
			 
			 if(profileTo.getProvince()!=null && !"".equals(profileTo.getProvince().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setProvince(profileTo.getProvince());
			 }	 
			 
			 if(profileTo.getCity()!=null && !"".equals(profileTo.getCity().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setCity(profileTo.getCity());
			 }			
			 
			 if(profileTo.getGoogleCountry()!=null && !"".equals(profileTo.getGoogleCountry().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setGoogleCountry(profileTo.getGoogleCountry());
			 }	
			 
			 if(profileTo.getGoogleProvince()!=null && !"".equals(profileTo.getGoogleProvince().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setGoogleProvince(profileTo.getGoogleProvince());
			 }	 
			 
			 if(profileTo.getGoogleCity()!=null && !"".equals(profileTo.getGoogleCity().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setGoogleCity(profileTo.getGoogleCity());
			 }		
			 
			 if(profileTo.getLongitude()!=null && !"".equals(profileTo.getLongitude().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setLongitude(Double.parseDouble(profileTo.getLongitude()));
			 }				 

			 if(profileTo.getLatitude()!=null && !"".equals(profileTo.getLatitude().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setLastAddressUpdate(currentTime);
				profileEntity.setLatitude(Double.parseDouble(profileTo.getLatitude()));
			 }	
			 
			 if(profileTo.getPassword()!=null && !"".equals(profileTo.getPassword().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setPassword(CryptWithMD5Util.cryptWithMD5Util(profileTo.getPassword()));
			 }	

			 if(profileTo.getNickname()!=null && !"".equals(profileTo.getNickname().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setNickname(profileTo.getNickname());
			 }	
			 
			 if(profileTo.getSignature()!=null && !"".equals(profileTo.getSignature().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setSignature(profileTo.getSignature());
			 }	
			 
			 if(profileTo.getGender()!=null && !"".equals(profileTo.getGender().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setGender(profileTo.getGender());
			 }	
			 
			 if(profileTo.getDateOfBirth()!=null && !"".equals(profileTo.getDateOfBirth().trim()))
			 {
				Date dateOfBirth =dobString.parse(profileTo.getDateOfBirth());
				profileEntity.setLastUpdate(currentTime); 
				profileEntity.setDateOfBirth(dateOfBirth);
			 }

			 /* update profile photo status, true means have profile photo, false means no*/
			 if(profileTo.getProfilePhoto()!=null && !"".equals(profileTo.getProfilePhoto().trim()))
			 {
				Boolean profilePhoto =Boolean.parseBoolean(profileTo.getProfilePhoto());
				profileEntity.setLastUpdate(currentTime); 
				profileEntity.setProfilePhoto(profilePhoto);
			 }			 
  	 
		      session.update(profileEntity); 	
		      tx.commit();
		      updateStatus=true;		      
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }		    
		return updateStatus;
	}

	
/* to read a profile record*/
//	public ProfileReadDTO readProfile(String email){
	public ProfileEntity readProfile(String email){		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ProfileEntity profileEntity = new ProfileEntity();
		
	    try{
		      tx = session.beginTransaction();

		      String sql = "select * from profile where email = ?";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, email);
		      query.addEntity(ProfileEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ProfileEntity> profileList = query.list();	
		      
		      if (profileList!=null && profileList.size()==1)
		    	  profileEntity = profileList.get(0);

		     // session.update(profileEntity); 	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return profileEntity;
	}

	/* Login Verification*/
	public LoginResultOutDTO authenticateCredential(String logInEmail, String logInPassword){
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
		//boolean loginStatus = false;
	    ProfileEntity profileEntity = new ProfileEntity();
	    String password = CryptWithMD5Util.cryptWithMD5Util(logInPassword);
	    LoginResultOutDTO output = new LoginResultOutDTO();
		
	    try{
		      tx = session.beginTransaction();

		      String sql = "select * from profile where email = ? and password = ?";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, logInEmail);
		      query.setString(1, password);
		      query.addEntity(ProfileEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ProfileEntity> profileList = query.list();	
		      
		      if (profileList!=null && profileList.size()==1){
		    	  profileEntity = profileList.get(0);
		    	  output.setStatus("Y");
		    	  output.setUsername(profileEntity.getEmail());
		    	  output.setUserid(profileEntity.getUserIntID());
		    	  output.setNickname(profileEntity.getNickname());
		      }

		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return output;
	}
	
}
