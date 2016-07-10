package com.william.DAO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.william.entity.AddressHistoryEntity;
import com.william.entity.ProfileEntity;
import com.william.to.AddressHistoryInDTO;
import com.william.to.AddressHistoryOutDTO;
import com.william.util.HibernateUtil;

public class AddressHistoryDAO {
	
	private static AddressHistoryDAO instance;
	
	public static AddressHistoryDAO getInstance() {
		if (instance == null) {
			instance = new AddressHistoryDAO();
		}
		return instance;
	}
	
	public void addAddressHistory(AddressHistoryInDTO addressTo)
	{
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String addressSequenceID = UUID.randomUUID().toString().replaceAll("-", "");
	      AddressHistoryEntity addressHistoryEntity = new AddressHistoryEntity();
	      Date updateTime = new Date();
	      
	      try{
		         tx = session.beginTransaction();

		         addressHistoryEntity.setUserIntID(addressTo.getUserIntID());
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
	
	public AddressHistoryOutDTO[] readAddressHistory(String userIntID, String placeType){	

		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    String[] cityListArray= null;

	    AddressHistoryOutDTO[] addressHistoryArray = null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select a.*, b.Nickname from addresshistory a join profile b on a.userintid = b.userintid where a.userIntID = ? and a.PlaceType = ? order by updatetime desc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, userIntID);
		      query.setString(1, placeType);
		      query.setResultTransformer(Transformers.aliasToBean(AddressHistoryOutDTO.class));
		      List<AddressHistoryOutDTO> adressHistoryList = query.list();	
		      addressHistoryArray = new AddressHistoryOutDTO[adressHistoryList.size()];
	    	  
		      if (adressHistoryList!=null && adressHistoryList.size()>0 ){
		    	  for (int i=0;i<adressHistoryList.size();i++){
		    		  addressHistoryArray[i] = adressHistoryList.get(i);

		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return addressHistoryArray;
	}
	
}
