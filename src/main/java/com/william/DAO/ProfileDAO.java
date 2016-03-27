package com.william.DAO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.LatestCoordinateEntity;
import com.william.entity.ProfileEntity;
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
	         outDto.setUserID(profileTo.getEmail());
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

		      String sql = "select * from profile where ShallWayID = '"+shallWayID+"'";
		      SQLQuery query = session.createSQLQuery(sql);     
		      query.addEntity(ProfileEntity.class);
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
}
