package com.william.DAO;

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
	      String shallWayID = UUID.randomUUID().toString().replaceAll("-", "");
	      String password = CryptWithMD5Util.cryptWithMD5Util(profileTo.getPassword());
	      ProfileEntity profileEntity = new ProfileEntity();
	      RegisterOutDTO outDto = new RegisterOutDTO();
	      Date registerTime = new Date();
 	      
	      try{
	         tx = session.beginTransaction();
	        // profile = new ProfileEntity(shallWayID, email, password, nickName, gender, dateOfBirth,
	     			//country, city, lastUpdate, createTime, lastAddressUpdate, status);
	         profileEntity.setShallWayID(shallWayID);
	         profileEntity.setPassword(password);
	         profileEntity.setEmail(profileTo.getEmail());
	         profileEntity.setNickName(profileTo.getNickname());
	         profileEntity.setCountry(profileTo.getCountry());
	         profileEntity.setProvince(profileTo.getProvince());
	         profileEntity.setCity(profileTo.getCity());
	         profileEntity.setCreateTime(registerTime);
	         profileEntity.setLastUpdate(registerTime);
	         profileEntity.setLastAddressUpdate(registerTime);
	         
               
	         session.save(profileEntity);
	         
	         outDto.setShallwayID(shallWayID);
	         outDto.setUserid(profileTo.getEmail());
	         outDto.setRegisterStatus("Registration Successful");
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return outDto;
	}
	
	/* to update a profile record*/
	public boolean updateProfile(ProfileInDTO profileTo)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ProfileEntity profileEntity = new ProfileEntity();
		boolean updateStatus = false;
		Date currentTime = new Date();
		String shallWayID = profileTo.getShallWayID();
			
	    try{
		      tx = session.beginTransaction();

//		      String sql = "select * from profile where ShallWayID = '"+shallWayID+"'";
		      String sql = "select * from profile where ShallWayID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, shallWayID);
		      query.addEntity(ProfileEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ProfileEntity> profileList = query.list();	
		      
		      /*method 1*/
		      if (profileList!=null)
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

			 if(profileTo.getPassword()!=null && !"".equals(profileTo.getPassword().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setPassword(CryptWithMD5Util.cryptWithMD5Util(profileTo.getPassword()));
			 }	

			 if(profileTo.getNickName()!=null && !"".equals(profileTo.getNickName().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setNickName(profileTo.getNickName());
			 }	
			 
			 if(profileTo.getStatus()!=null && !"".equals(profileTo.getStatus().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setStatus(profileTo.getStatus());
			 }	
			 
			 if(profileTo.getGender()!=null && !"".equals(profileTo.getGender().trim()))
			 {
				profileEntity.setLastUpdate(currentTime);
				profileEntity.setGender(profileTo.getGender());
			 }	
			 
			 if(profileTo.getDateOfBirth()!=null)
			 {
				profileEntity.setLastUpdate(currentTime); 
				profileEntity.setDateOfBirth(profileTo.getDateOfBirth());
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
		      
		      if (profileList!=null)
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
		    	  output.setUserIntID(profileEntity.getShallWayID());
		    	  output.setUserid(profileEntity.getEmail());
		    	  output.setNickname(profileEntity.getNickName());
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
