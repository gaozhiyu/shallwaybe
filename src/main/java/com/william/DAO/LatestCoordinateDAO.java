package com.william.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.util.HibernateUtil;
import com.william.entity.LatestCoordinateEntity;
import com.william.to.LatestCoordinateInDTO;


public class LatestCoordinateDAO {
	
	/*Create Coordinate Record*/
	public void addLatestCoordinate(LatestCoordinateInDTO latestCoordinateInDTO){	
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      LatestCoordinateEntity latestcoordinate = new LatestCoordinateEntity();
	      Date updateTime = new Date();
	      
	      try{
	    	  
	         tx = session.beginTransaction();
	         
	         latestcoordinate.setShallWayID(latestCoordinateInDTO.getShallWayID());
	         latestcoordinate.setLongitude(latestCoordinateInDTO.getLongitude());
	         latestcoordinate.setLatitude(latestCoordinateInDTO.getLatitude());
//	         latestcoordinate.setLastShakeTime(latestCoordinateInDTO.getLastShakeTime());
	         latestcoordinate.setLastShakeTime(updateTime);
	         latestcoordinate.setCountry(latestCoordinateInDTO.getCountry());
	         latestcoordinate.setProvince(latestCoordinateInDTO.getProvince());
	         latestcoordinate.setCity(latestCoordinateInDTO.getCity());
	         latestcoordinate.setLastAddressUpdate(updateTime);
	         
	         session.save(latestcoordinate);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
	}
	
	/*Update Coordinate Record*/
	public boolean updateLatestCoordinate(LatestCoordinateInDTO latestCoordinateInDTO){
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    Date updateTime = new Date();
	    boolean flag = false;
	    String shallWayID = latestCoordinateInDTO.getShallWayID();
	    LatestCoordinateEntity latestCoordinateEntity= new LatestCoordinateEntity(); /*for method 1 only*/
	    
	    try{
		      tx = session.beginTransaction();
		      
		      String sql = "select * from latestcoordinate where ShallWayID = ?";
		      SQLQuery query = session.createSQLQuery(sql);     
		      query.setString(0, shallWayID);
		      query.addEntity(LatestCoordinateEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<LatestCoordinateEntity> latestcoordinatelist = query.list();	
		      

		      if (latestcoordinatelist!=null)
		    	  latestCoordinateEntity = latestcoordinatelist.get(0);

		      if (latestCoordinateInDTO.getCountry()!=null && !"".equals(latestCoordinateInDTO.getCountry().trim())){
		    	  latestCoordinateEntity.setCountry(latestCoordinateInDTO.getCountry());
		    	  latestCoordinateEntity.setLastAddressUpdate(updateTime);
		      }
		      
		      if (latestCoordinateInDTO.getProvince()!=null && !"".equals(latestCoordinateInDTO.getProvince().trim())){
		    	  latestCoordinateEntity.setProvince(latestCoordinateInDTO.getProvince());
		    	  latestCoordinateEntity.setLastAddressUpdate(updateTime);
		      }
		      
		      if (latestCoordinateInDTO.getCity()!=null && !"".equals(latestCoordinateInDTO.getCity().trim())){
		    	  latestCoordinateEntity.setCity(latestCoordinateInDTO.getCity());
		    	  latestCoordinateEntity.setLastAddressUpdate(updateTime);
		      }
		      
		      if (latestCoordinateInDTO.getLongitude()!=null){
		    	  latestCoordinateEntity.setLongitude(latestCoordinateInDTO.getLongitude());
		    	  latestCoordinateEntity.setLastShakeTime(updateTime);
		      }
		      
		      if (latestCoordinateInDTO.getLatitude()!=null){
		    	  latestCoordinateEntity.setLatitude(latestCoordinateInDTO.getLatitude());
		    	  latestCoordinateEntity.setLastShakeTime(updateTime);
		      }
		      
//		      if (latestCoordinateInDTO.getLastShakeTime()!=null){
//		    	  latestCoordinateEntity.setLastShakeTime(latestCoordinateInDTO.getLastShakeTime());
//		      }
		     	      	 
			  session.update(latestCoordinateEntity); 	
		      tx.commit();
			  flag =true;
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }		
	    return flag;
	}

//	/*Update Coordinate Record: update longitude & latitude only*/
//	public void updateLatestCoordinate (String shallWayID,Double longitude, Double latitude, Date lastShakeTime){
//		  
//		Session session = HibernateUtil.getSessionFactory().openSession();
//	    Transaction tx = null;		
//	    try{
//		      tx = session.beginTransaction();
//	      
//		         LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
//		      	 latestcoordinate.setLongitude(longitude);
//		      	 latestcoordinate.setLatitude(latitude);
//		      	 latestcoordinate.setLastShakeTime(lastShakeTime);    	 
//				 session.update(latestcoordinate); 		      
//		      tx.commit();
//		    }catch (HibernateException e) {
//		      if (tx!=null) tx.rollback();
//		      e.printStackTrace(); 
//		    }finally {
//		      session.close(); 
//		    }		    
//	}
//	/*Update Coordinate Record: update country & city only*/
//	public void updateLatestCoordinate (String shallWayID, String country, String province, String city, Date lastAddressUpdate){
//		  
//		Session session = HibernateUtil.getSessionFactory().openSession();
//	    Transaction tx = null;		
//	    try{
//		      tx = session.beginTransaction();
//		      
//		         LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
//		      	 latestcoordinate.setCountry(country);	
//		      	 latestcoordinate.setProvince(province);
//		      	 latestcoordinate.setCity(city);	
//		      	 latestcoordinate.setLastAddressUpdate(lastAddressUpdate);		      	 
//		      	 
//				 session.update(latestcoordinate); 		      
//		      tx.commit();
//		    }catch (HibernateException e) {
//		      if (tx!=null) tx.rollback();
//		      e.printStackTrace(); 
//		    }finally {
//		      session.close(); 
//		    }		    
//	}
//	
	
	/* Read Latest Coordinate Record */
//	public LatestCoordinateEntity[] readLatestCoordinate(String shallWayID){
	public LatestCoordinateEntity readLatestCoordinate(String shallWayID){	
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
//	      LatestCoordinateEntity[] latestCoordinateArray =null;
	      LatestCoordinateEntity latestCoordinateEntity= new LatestCoordinateEntity();
	      
	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from latestcoordinate where ShallWayID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, shallWayID);
		      query.addEntity(LatestCoordinateEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<LatestCoordinateEntity> latestCoordinateList = query.list();	      
		      
		      if (latestCoordinateList!=null)
		    	  latestCoordinateEntity = latestCoordinateList.get(0);     
		      
//		      latestCoordinateArray = new LatestCoordinateEntity[latestCoordinateList.size()];		      
//		      if (latestCoordinateList!=null){
//		    	  for (int i=0;i<latestCoordinateList.size();i++)
//		    		  latestCoordinateArray[i] = latestCoordinateList.get(i);
//	  
//		      }

	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return latestCoordinateEntity;
//	      return latestCoordinateArray;
	      
	   }
}
