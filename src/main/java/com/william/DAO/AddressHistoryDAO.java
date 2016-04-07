package com.william.DAO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.AddressHistoryEntity;
import com.william.entity.ProfileEntity;
import com.william.to.AddressHistoryInDTO;
import com.william.to.AddressHistoryOutDTO;
import com.william.util.HibernateUtil;

public class AddressHistoryDAO {
	
	public void addAddressHistory(AddressHistoryInDTO addressTo)
	{
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String addressSequenceID = UUID.randomUUID().toString().replaceAll("-", "");
	      AddressHistoryEntity addressHistoryEntity = new AddressHistoryEntity();
	      Date updateTime = new Date();
	      
	      try{
		         tx = session.beginTransaction();

		         addressHistoryEntity.setShallWayID(addressTo.getShallWayID());
		         addressHistoryEntity.setAddressSequenceID(addressSequenceID);
		         addressHistoryEntity.setCountry(addressTo.getCountry());
		         addressHistoryEntity.setProvince(addressTo.getProvince());
		         addressHistoryEntity.setCity(addressTo.getCity());
		         addressHistoryEntity.setUpdateTime(updateTime);
		         addressHistoryEntity.setPlaceType(addressTo.getPlaceType());
		         
		         session.save(addressHistoryEntity);
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
//		      return outDto;	         
	}

//	public AddressHistoryOutDTO readAddressHistory(String shallWayID, String placeType){	
	public String[] readAddressHistory(String shallWayID, String placeType){		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    String[] cityListArray= null;
	    AddressHistoryEntity addressHistory = new AddressHistoryEntity();
//	    AddressHistoryOutDTO addressHistoryOutDTO = new AddressHistoryOutDTO();
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select * from addresshistory where ShallWayID = ? and PlaceType = ? order by updatetime DESC";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, shallWayID);
		      query.setString(1, placeType);
		      query.addEntity(AddressHistoryEntity.class);
		      List<AddressHistoryEntity> adressHistoryList = query.list();	
	    	  cityListArray = new String[adressHistoryList.size()];	
	    	  
		      if (adressHistoryList!=null){
		    	  for (int i=0;i<adressHistoryList.size();i++){
		    		addressHistory = adressHistoryList.get(i);
		    	  	cityListArray[i]=addressHistory.getCity();  
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return cityListArray;
	}
	
}
