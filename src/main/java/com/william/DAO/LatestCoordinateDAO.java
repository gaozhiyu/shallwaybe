package com.william.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.william.util.HibernateUtil;
import com.william.entity.LatestCoordinateEntity;
import com.william.to.LatestCoordinateInDTO;
import com.william.to.LatestCoordinateOutDTO;


public class LatestCoordinateDAO {
	
	private static LatestCoordinateDAO instance;
	
	public static LatestCoordinateDAO getInstance() {
		if (instance == null) {
			instance = new LatestCoordinateDAO();
		}
		return instance;
	}
	
	/*Create Coordinate Record*/
//	public void addLatestCoordinate(LatestCoordinateInDTO latestCoordinateInDTO){	
//		
//		  Session session = HibernateUtil.getSessionFactory().openSession();
//	      Transaction tx = null;
//	      LatestCoordinateEntity latestcoordinate = new LatestCoordinateEntity();
//	      Date updateTime = new Date();
//	      
//	      
//	      try{
//	    	  
//	         tx = session.beginTransaction();
//	         
//	         latestcoordinate.setUserIntID(latestCoordinateInDTO.getUserIntID());
////	         latestcoordinate.setNickName(latestCoordinateInDTO.getNickName());
//	         latestcoordinate.setLongitude(Double.parseDouble(latestCoordinateInDTO.getLongitude()));
//	         latestcoordinate.setLatitude(Double.parseDouble(latestCoordinateInDTO.getLatitude()));
////	         latestcoordinate.setLastShakeTime(latestCoordinateInDTO.getLastShakeTime());
//	         latestcoordinate.setLastShakeTime(updateTime);
//	         latestcoordinate.setCountry(latestCoordinateInDTO.getCountry());
//	         latestcoordinate.setProvince(latestCoordinateInDTO.getProvince());
//	         latestcoordinate.setCity(latestCoordinateInDTO.getCity());
//	         latestcoordinate.setLastAddressUpdate(updateTime);
//	         
//	         session.save(latestcoordinate);
//	         tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }		
//	}
	
	/*To Add or Update Coordinate Record*/
	public boolean saveOrUpdateLatestCoordinate(LatestCoordinateInDTO latestCoordinateInDTO){
		  
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    Date updateTime = new Date();
	    boolean flag = false;
	    String userIntID = latestCoordinateInDTO.getUserIntID();
	    LatestCoordinateEntity latestCoordinateEntity= new LatestCoordinateEntity(); /*for method 1 only*/
	    
	    try{
		      tx = session.beginTransaction();
		      
		      String sql = "select * from latestcoordinate where UserIntID = ?";
		      SQLQuery query = session.createSQLQuery(sql);     
		      query.setString(0, userIntID);
		      query.addEntity(LatestCoordinateEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<LatestCoordinateEntity> latestcoordinatelist = query.list();	
		      
		      if (latestcoordinatelist!=null && latestcoordinatelist.size()> 0){
		    	  latestCoordinateEntity = latestcoordinatelist.get(0);
		      } else {
		    	  latestCoordinateEntity.setUserIntID(latestCoordinateInDTO.getUserIntID());
		      }

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
		      
		      if (latestCoordinateInDTO.getLongitude()!=null && !"".equals(latestCoordinateInDTO.getLongitude().trim())){
		    	  latestCoordinateEntity.setLongitude(Double.parseDouble(latestCoordinateInDTO.getLongitude()));
		    	  latestCoordinateEntity.setLastShakeTime(updateTime);
		      }
		      
		      if (latestCoordinateInDTO.getLatitude()!=null && !"".equals(latestCoordinateInDTO.getLatitude().trim())){
		    	  latestCoordinateEntity.setLatitude(Double.parseDouble(latestCoordinateInDTO.getLatitude()));
		    	  latestCoordinateEntity.setLastShakeTime(updateTime);
		      }
		      
			  session.saveOrUpdate(latestCoordinateEntity); 	
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

	public LatestCoordinateOutDTO readLatestCoordinate(String userIntID){
	
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
//	      LatestCoordinateOutDTO latestCoordinate = new LatestCoordinateOutDTO(); // commented on 17.7.2016
	      LatestCoordinateOutDTO latestCoordinate = null; // updated on 17.7.2016 for null object
	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select b.nickname as nickname,a.userintid as userIntID,a.longitude as longitude,a.latitude as latitude,a.lastshaketime as lastShakeTime,a.country as country,a.province as province,a.city as city,a.lastaddressupdate as lastAddressUpdate from latestcoordinate a join profile b on a.userintid = b.userintid where a.userintid = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, userIntID);
		      query.setResultTransformer(Transformers.aliasToBean(LatestCoordinateOutDTO.class));
		      
		      @SuppressWarnings("unchecked")
		      List<LatestCoordinateOutDTO> latestCoordinateList = query.list();	      
		      
		      if (latestCoordinateList!=null && latestCoordinateList.size()>0 )
		    	  latestCoordinate = latestCoordinateList.get(0);     
		      
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return latestCoordinate;
	      
	   }
}
