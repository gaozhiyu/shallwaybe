package com.william.DAO;

import java.util.Date;
import java.util.Iterator;
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

public class ShallWayDAO {
	
	/* Create ShallWay Record*/
		public void addShallWay (String shallWayID, String country, String city, String place, Date startTime, Date endTime,
			Date postTime, Boolean carPool, Boolean freeTour, Boolean hotelShare, Boolean freeGuide, String title,
			String contact, String description)	{
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String id = UUID.randomUUID().toString().replaceAll("-", "");

	      try{
	         tx = session.beginTransaction();
	         ShallWayEntity shallWay = new ShallWayEntity(id,shallWayID, country, city, place, startTime, endTime,
	     			postTime, carPool, freeTour, hotelShare, freeGuide, title,
	    			contact, description);

	         session.save(shallWay);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }

		}
	
		/* Read ShallWay Record*/
	   public void listShallWay( ){
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         
		         String sql = "select * from shallway";
		         SQLQuery query = session.createSQLQuery(sql);
		         query.addEntity(ShallWayEntity.class);
		         List<ShallWayEntity> shallWays = query.list();
		         
		         for (Iterator iterator = shallWays.iterator(); iterator.hasNext();){
		            ShallWayEntity shallWay = (ShallWayEntity) iterator.next(); 
		            
//		            for (ShallWayEntity shallWay : shallWays){		
		            
		            System.out.println("ID: " + shallWay.getId()); 
		            System.out.println("ShallWayID: " + shallWay.getShallWayID()); 
		            System.out.println("Country: " + shallWay.getCountry()); 
		            System.out.println("City: " + shallWay.getCity());
		            System.out.println("Place: " + shallWay.getPlace());
		            System.out.println("StartTime: " + shallWay.getStartTime());
		            System.out.println("EndTime: " + shallWay.getEndTime());
		            System.out.println("PostTime: " + shallWay.getPostTime());
		            
		            System.out.println("CarPool: " + shallWay.getCarPool());
		            System.out.println("FreeTour: " + shallWay.getFreeTour());
		            System.out.println("HotelShare: " + shallWay.getHotelShare());
		            System.out.println("FreeGuide: " + shallWay.getFreeGuide());
		            
		            System.out.println("Title: " + shallWay.getTitle());
		            System.out.println("Contact: " + shallWay.getContact());
		            System.out.println("Description: " + shallWay.getDescription());
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
	   /*update ShallWay Record*/	
		public boolean updateShallWay (String id,String shallWayID, String country, String city, String place, Date startTime, Date endTime,
				Date postTime, Boolean carPool, Boolean freeTour, Boolean hotelShare, Boolean freeGuide, String title,
				String contact, String description)	{
			
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      boolean flag = false;

		      try{
		         tx = session.beginTransaction();
		         ShallWayEntity shallWay = new ShallWayEntity(id,shallWayID,country, city, place, startTime, endTime,
		     			postTime, carPool, freeTour, hotelShare, freeGuide, title,
		    			contact, description);

		         session.update(shallWay);
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

			      try{
			         tx = session.beginTransaction();
			         ShallWayEntity shallWay =(ShallWayEntity)session.get(ShallWayEntity.class, id);
			         session.delete(shallWay);
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }

				}	

}
