package com.william.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.util.HibernateUtil;
import com.william.entity.LatestCoordinateEntity;


public class LatestCoordinateDAO {
	
	/*Create Coordinate Record*/
	public void addLatestCoordinate(String shallWayID, Double longitude, Double latitude, Date lastShakeTime,
			String country, String city, Date lastAddressUpdate)
	{
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         LatestCoordinateEntity latestcoordinate = new LatestCoordinateEntity(shallWayID,longitude,latitude,lastShakeTime,country,city,lastAddressUpdate);
	         session.save(latestcoordinate);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
	}
	
	/*Update Coordinate Record: update all fields*/
	public void updateLatestCoordinate (String shallWayID,Double longitude, Double latitude, Date lastShakeTime,
			String country, String city, Date lastAddressUpdate){
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
//	    LatestCoordinateEntity latestcoordinate=null; /*for method 1 only*/
	    try{
		      tx = session.beginTransaction();
		      
		      //to be updated using query list
//		      String sql = "select * from latestcoordinate where ShallWayID = '"+shallWayID+"'";
//		      SQLQuery query = session.createSQLQuery(sql);     
//		      query.addEntity(LatestCoordinateEntity.class);
//		      List<LatestCoordinateEntity> latestcoordinatelist = query.list();	
		      
		      /*method 1*/
//		      if (latestcoordinatelist!=null)
//		    	  latestcoordinate = latestcoordinatelist.get(0);
	
//		      /*method 2*/
//		      for (LatestCoordinateEntity latestcoordinate:latestcoordinatelist){

		      /*method 3*/
		         LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
		      	 latestcoordinate.setLongitude(longitude);
		      	 latestcoordinate.setLatitude(latitude);
		      	 latestcoordinate.setLastShakeTime(lastShakeTime);
		      	 latestcoordinate.setCountry(country);	
		      	 latestcoordinate.setCity(city);	
		      	 latestcoordinate.setLastAddressUpdate(lastAddressUpdate);		      	 
		      	 
				 session.update(latestcoordinate); 		      
		      tx.commit();
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }		    
	}

	/*Update Coordinate Record: update longitude & latitude only*/
	public void updateLatestCoordinate (String shallWayID,Double longitude, Double latitude, Date lastShakeTime){
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;		
	    try{
		      tx = session.beginTransaction();
	      
		         LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
		      	 latestcoordinate.setLongitude(longitude);
		      	 latestcoordinate.setLatitude(latitude);
		      	 latestcoordinate.setLastShakeTime(lastShakeTime);    	 
				 session.update(latestcoordinate); 		      
		      tx.commit();
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }		    
	}
	/*Update Coordinate Record: update country & city only*/
	public void updateLatestCoordinate (String shallWayID, String country, String city, Date lastAddressUpdate){
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;		
	    try{
		      tx = session.beginTransaction();
		      
		         LatestCoordinateEntity latestcoordinate = (LatestCoordinateEntity)session.get(LatestCoordinateEntity.class, shallWayID); 
		      	 latestcoordinate.setCountry(country);	
		      	 latestcoordinate.setCity(city);	
		      	 latestcoordinate.setLastAddressUpdate(lastAddressUpdate);		      	 
		      	 
				 session.update(latestcoordinate); 		      
		      tx.commit();
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }		    
	}
	
}
