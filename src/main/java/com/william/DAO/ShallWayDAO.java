package com.william.DAO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

import com.william.util.HibernateUtil;
import com.william.entity.ShallWayEntity;
import com.william.to.ShallWayInDTO;
import com.william.to.ShallWayUpdateDTO;

public class ShallWayDAO {
	
	/* Create ShallWay Record*/
		public void addShallWay (ShallWayInDTO shallWayInDTO){
			
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String id = UUID.randomUUID().toString().replaceAll("-", "");
	      ShallWayEntity shallWayEntity = new ShallWayEntity();
	      Date postTime = new Date();
	      
	      try{
	         tx = session.beginTransaction();
	         
	         shallWayEntity.setId(id);
	         shallWayEntity.setShallWayID(shallWayInDTO.getShallWayID());
	         shallWayEntity.setCountry(shallWayInDTO.getCountry());
	         shallWayEntity.setProvince(shallWayInDTO.getProvince());
	         shallWayEntity.setCity(shallWayInDTO.getCity());
	         shallWayEntity.setPlace(shallWayInDTO.getPlace());
	         shallWayEntity.setStartTime(shallWayInDTO.getStartTime());
	         shallWayEntity.setEndTime(shallWayInDTO.getEndTime());
	         shallWayEntity.setPostTime(postTime);
	         shallWayEntity.setCarPool(shallWayInDTO.getCarPool());
	         shallWayEntity.setFreeTour(shallWayInDTO.getFreeTour());
	         shallWayEntity.setHotelShare(shallWayInDTO.getHotelShare());
	         shallWayEntity.setFreeGuide(shallWayInDTO.getFreeGuide());
	         shallWayEntity.setTitle(shallWayInDTO.getTitle());
	         shallWayEntity.setContact(shallWayInDTO.getContact());
	         shallWayEntity.setDescription(shallWayInDTO.getDescription());
	         
	         session.save(shallWayEntity);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }

		}
	
		/* Read ShallWay Record*/
	   public ShallWayEntity[] readShallWay(String shallWayID){
		   
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ShallWayEntity[] shallWayArray =null;
		      
		      try{
		         tx = session.beginTransaction();
		         
			      String sql = "select * from shallway where ShallWayID = ? order by posttime DESC";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, shallWayID);
			      query.addEntity(ShallWayEntity.class);
			      
			      @SuppressWarnings("unchecked")
			      List<ShallWayEntity> shallWayList = query.list();	
			      
			      shallWayArray = new ShallWayEntity[shallWayList.size()];
			            
			      if (shallWayList!=null){
			    	  for (int i=0;i<shallWayList.size();i++)
			    	  shallWayArray[i] = shallWayList.get(i);
   	  
			      }

		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return shallWayArray;
		   }
	   /*update ShallWay Record*/	
		public boolean updateShallWay (ShallWayUpdateDTO shallWayUpdateDTO){	
			
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      boolean flag = false;
		      ShallWayEntity shallWayEntity = new ShallWayEntity();
		      Date postTime = new Date();
		      String id = shallWayUpdateDTO.getId();

		      try{
		         tx = session.beginTransaction();
		         
			      String sql = "select * from shallway where id = ?";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, id);
			      query.addEntity(ShallWayEntity.class);
			      
			      @SuppressWarnings("unchecked")
			      List<ShallWayEntity> shallWayList = query.list();	
			            
			      if (shallWayList!=null)
			    	  shallWayEntity = shallWayList.get(0);
			      
			      if (shallWayUpdateDTO.getCountry()!=null && !"".equals(shallWayUpdateDTO.getCountry().trim())){
			    	  shallWayEntity.setCountry(shallWayUpdateDTO.getCountry());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getProvince()!=null && !"".equals(shallWayUpdateDTO.getProvince().trim())){
			    	  shallWayEntity.setProvince(shallWayUpdateDTO.getProvince());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getCity()!=null && !"".equals(shallWayUpdateDTO.getCity().trim())){
			    	  shallWayEntity.setCity(shallWayUpdateDTO.getCity());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getPlace()!=null && !"".equals(shallWayUpdateDTO.getPlace().trim())){
			    	  shallWayEntity.setPlace(shallWayUpdateDTO.getPlace());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getStartTime()!=null){
			    	  shallWayEntity.setStartTime(shallWayUpdateDTO.getStartTime());
			    	  shallWayEntity.setPostTime(postTime);
			      }

			      if (shallWayUpdateDTO.getEndTime()!=null){
			    	  shallWayEntity.setEndTime(shallWayUpdateDTO.getEndTime());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getCarPool()!=null){
			    	  shallWayEntity.setCarPool(shallWayUpdateDTO.getCarPool());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getFreeTour()!=null){
			    	  shallWayEntity.setFreeTour(shallWayUpdateDTO.getFreeTour());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getHotelShare()!=null){
			    	  shallWayEntity.setHotelShare(shallWayUpdateDTO.getHotelShare());
			    	  shallWayEntity.setPostTime(postTime);
			      }
	
			      if (shallWayUpdateDTO.getFreeGuide()!=null){
			    	  shallWayEntity.setFreeGuide(shallWayUpdateDTO.getFreeGuide());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getTitle()!=null && !"".equals(shallWayUpdateDTO.getTitle().trim())){
			    	  shallWayEntity.setTitle(shallWayUpdateDTO.getTitle());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getContact()!=null && !"".equals(shallWayUpdateDTO.getContact().trim())){
			    	  shallWayEntity.setContact(shallWayUpdateDTO.getContact());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getDescription()!=null && !"".equals(shallWayUpdateDTO.getDescription().trim())){
			    	  shallWayEntity.setDescription(shallWayUpdateDTO.getDescription());
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
		         session.update(shallWayEntity);
		         tx.commit();
		         flag = true;
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return flag;
			}	
		
		  /*delete a ShallWay Record*/	
			public void deleteShallWay (String id,String shallWayID){
				
				  Session session = HibernateUtil.getSessionFactory().openSession();
			      Transaction tx = null;
			      ShallWayEntity shallWayEntity = new ShallWayEntity();

			      try{
			         tx = session.beginTransaction();
			         
				      String sql = "select * from shallway where id = ? and shallwayid = ?";
				      SQLQuery query = session.createSQLQuery(sql);
				      query.setString(0, id);
				      query.setString(1, shallWayID);
				      query.addEntity(ShallWayEntity.class);
				      
				      @SuppressWarnings("unchecked")
				      List<ShallWayEntity> shallWayList = query.list();	
				      
				      if (shallWayList!=null)
				    	  shallWayEntity = shallWayList.get(0);
			            
			         session.delete(shallWayEntity);
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }

				}	

}
