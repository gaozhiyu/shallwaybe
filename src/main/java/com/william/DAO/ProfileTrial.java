package com.william.DAO;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.ProfileEntity;
import com.william.to.ProfileTo;
import com.william.util.CryptWithMD5Util;
import com.william.util.HibernateUtil;

public class ProfileTrial {
	
	/*Create Profile Record*/
	public ProfileTo addProfile(ProfileTo profileTo
			//String email, String password, String nickName, String gender, Date dateOfBirth,
			//String country, String city, Date lastUpdate, Date createTime, Date lastAddressUpdate, String status
			){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String shallWayID = UUID.randomUUID().toString().replaceAll("-", "");
	      String password = CryptWithMD5Util.cryptWithMD5Util(profileTo.getPassword()); // to update
	      ProfileEntity profileEntity = new ProfileEntity();
	      
	      
	      
	      try{
	         tx = session.beginTransaction();
	        // profile = new ProfileEntity(shallWayID, email, password, nickName, gender, dateOfBirth,
	     			//country, city, lastUpdate, createTime, lastAddressUpdate, status);
	         profileEntity.setCity(profileTo.getCity());
	         
	         
	         
	         session.save(profileEntity);
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return profileTo;
	}

}
