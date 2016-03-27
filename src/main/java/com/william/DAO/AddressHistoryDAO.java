package com.william.DAO;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.AddressHistoryEntity;
import com.william.to.AddressHistoryInDTO;
import com.william.util.HibernateUtil;

public class AddressHistoryDAO {
	
	public void addAddressHistory(AddressHistoryInDTO addressTo)
	{
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String addressSequenceID = UUID.randomUUID().toString().replaceAll("-", "");
	      AddressHistoryEntity addressHistoryEntity = new AddressHistoryEntity();
	      
	      try{
		         tx = session.beginTransaction();

		         addressHistoryEntity.setShallWayID(addressTo.getShallWayID());
		         addressHistoryEntity.setAddressSequenceID(addressSequenceID);
		         addressHistoryEntity.setCountry(addressTo.getCountry());
		         addressHistoryEntity.setCity(addressTo.getCity());
		         addressHistoryEntity.setUpdateTime(addressTo.getUpdateTime());
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
}
