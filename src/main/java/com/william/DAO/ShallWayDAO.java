package com.william.DAO;

import java.math.BigInteger;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import com.william.util.HibernateUtil;
import com.william.util.XssShieldUtil;
import com.william.entity.ShallWayEntity;
import com.william.to.ShallWayInDTO;
import com.william.to.ShallWayOutDTO;
import com.william.to.ShallWaySearchDTO;
import com.william.to.ShallWayUpdateDTO;

public class ShallWayDAO {
	
	private static ShallWayDAO instance;
	
	public static ShallWayDAO getInstance() {
		if (instance == null) {
			instance = new ShallWayDAO();
		}
		return instance;
	}
	
	/* Create ShallWay Record*/
		public String addShallWay(ShallWayInDTO shallWayInDTO) throws ParseException{
			
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String dateID = UUID.randomUUID().toString().replaceAll("-", "");
	      ShallWayEntity shallWayEntity = new ShallWayEntity();
	      Date postTime = new Date();
	      SimpleDateFormat sdfd =new SimpleDateFormat("dd/MM/yyyy");

	      try{
	         tx = session.beginTransaction();
	         
	         shallWayEntity.setDateID(dateID);
	         shallWayEntity.setUserIntID(shallWayInDTO.getUserIntID());
//	         shallWayEntity.setNickName(shallWayInDTO.getNickName());
	         shallWayEntity.setCountry(shallWayInDTO.getCountry());
	         shallWayEntity.setProvince(shallWayInDTO.getProvince());
	         shallWayEntity.setCity(shallWayInDTO.getCity());
	         
	         String place = XssShieldUtil.stripXss(shallWayInDTO.getPlace());
	         shallWayEntity.setPlace(place);
	         
		     Date startTime =sdfd.parse(shallWayInDTO.getStartTime());
	         shallWayEntity.setStartTime(startTime);
	         Date endTime =sdfd.parse(shallWayInDTO.getEndTime());
	         shallWayEntity.setEndTime(endTime);
	         shallWayEntity.setPostTime(postTime);
	         shallWayEntity.setCarPool(Boolean.parseBoolean(shallWayInDTO.getCarPool()));
	         shallWayEntity.setFreeTour(Boolean.parseBoolean(shallWayInDTO.getFreeTour()));
	         shallWayEntity.setHotelShare(Boolean.parseBoolean(shallWayInDTO.getHotelShare()));
	         shallWayEntity.setFreeGuide(Boolean.parseBoolean(shallWayInDTO.getFreeGuide()));
	         
	         String title = XssShieldUtil.stripXss(shallWayInDTO.getTitle());
	         shallWayEntity.setTitle(title);
	         String contact = XssShieldUtil.stripXss(shallWayInDTO.getContact());
	         shallWayEntity.setContact(contact);
	         if(StringUtils.isNotBlank(shallWayInDTO.getDescription())){
		         String descriptionString = XssShieldUtil.stripXss(shallWayInDTO.getDescription());
		         Blob description = Hibernate.getLobCreator(session).createBlob(descriptionString.getBytes());
		         shallWayEntity.setDescription(description);
	         }
	         
	         shallWayEntity.setDeleteStatus(false);
	         
	         session.save(shallWayEntity);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return dateID;

		}
		
		
		/* Read one ShallWay Record to be displayed with details in APP*/
	public ShallWayOutDTO retrieveDateByDateID(String dateID) throws SQLException{
		   
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
//		      ShallWayOutDTO shallWay = new ShallWayOutDTO();
		      ShallWayOutDTO shallWay = null;
		      byte[] bdata= null;
		      Blob blob=null;
		      
		      try{
		         tx = session.beginTransaction();
		         
			      String sql = "select * from ShallWayView where dateID = ? and deletestatus = false";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, dateID);
			      query.addEntity(ShallWayOutDTO.class);
//			      query.addScalar("Description", new StringType());
//			      query.setResultTransformer(Transformers.aliasToBean(ShallWayOutDTO.class));
			      
			      
			      @SuppressWarnings("unchecked")
			      List<ShallWayOutDTO> shallWayList = query.list();	
			      
			      if (shallWayList!=null && shallWayList.size()>0){
			    	  shallWay= shallWayList.get(0);
// updated on 01.08.2016 for Blob conversion in ShallWayOutDTO			    	  		    	  
 		    		  blob = shallWay.getDescriptionBlob();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String description = new String(bdata);
					  shallWay.setDescriptionStr(description);
// end of update 01.08.2016
			      }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return shallWay;
		   }
	
		/* Read ShallWay Record for user himself/herself*/
	public ShallWayEntity[] readShallWay(String userIntID, int pageNumber){
		   
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ShallWayEntity[] shallWayArray =null;
		      int pageSize =10;
		      
		      try{
		         tx = session.beginTransaction();
		         
			      String sql = "select * from ShallWay where UserIntID = ? and deletestatus = false order by posttime DESC";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, userIntID);
			      query.addEntity(ShallWayEntity.class);
			      query.setFirstResult((pageNumber-1) * pageSize);
			      query.setMaxResults(pageSize);
	      
			      
			      @SuppressWarnings("unchecked")
			      List<ShallWayEntity> shallWayList = query.list();	
			      
			      shallWayArray = new ShallWayEntity[shallWayList.size()];
			            
			      if (shallWayList!=null && shallWayList.size()>0){
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
	
	/* Search ShallWay Record based on criteria with Pagination */
	public ShallWayOutDTO[] readShallWay(ShallWaySearchDTO shallWaySearchDTO) throws ParseException, SQLException{
	   
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      ShallWayOutDTO[] shallWayArray =null;
	      SimpleDateFormat sdfd =new SimpleDateFormat("dd/MM/yyyy");
	      int pageSize =5;
	      byte[] bdata= null;
	      Blob blob=null;
	      
	      try{
	         tx = session.beginTransaction();
	        	         
	         Criteria crit = session.createCriteria(ShallWayOutDTO.class);
//	         crit.setFirstResult((Integer.parseInt(shallWaySearchDTO.getPageNumber()) - 1) * pageSize); //removed on 27.11.2016 in order to add sequenceNo.
	         crit.setFirstResult(0);
	         crit.setMaxResults(pageSize);
	         
//	         added on 27.11.2016 to check sequenceNo.
	         if (shallWaySearchDTO.getSequenceNo()!= null){
	        	 BigInteger seqID = new BigInteger(shallWaySearchDTO.getSequenceNo());
	        	 crit.add(Restrictions.lt("sequenceID",seqID));
	         }
//	         @SuppressWarnings("unchecked")
//	         List<ShallWayOutDTO> shallWayList = crit.add(Restrictions.eq("country",shallWaySearchDTO.getCountry()))
//	        		 								 .add(Restrictions.eq("province",shallWaySearchDTO.getProvince()))		
//	        		 								 .add(Restrictions.eq("city",shallWaySearchDTO.getCity()))
//	        		 								 .add(Restrictions.or(
//	        		 										 Restrictions.like("place",shallWaySearchDTO.getPlace().trim(),MatchMode.ANYWHERE), 
//	        		 										 Restrictions.isNull("place")))
//	        		 								 .add( Restrictions.and(
//	        		 							    		Restrictions.le("startTime", sdfd.parse(shallWaySearchDTO.getEndTime())),
//	        		 							    		Restrictions.ge("endTime", sdfd.parse(shallWaySearchDTO.getStartTime()))
//	        		 							       ))
//	        		 							     .add(Restrictions.disjunction()
//	        		 							           .add(Restrictions.eq("carPool", Boolean.parseBoolean(shallWaySearchDTO.getCarPool())))
//	        		 							           .add(Restrictions.eq("freeTour", Boolean.parseBoolean(shallWaySearchDTO.getFreeTour())))
//	        		 							           .add(Restrictions.eq("hotelShare", Boolean.parseBoolean(shallWaySearchDTO.getHotelShare())))
//	        		 							           .add(Restrictions.eq("freeGuide", Boolean.parseBoolean(shallWaySearchDTO.getFreeGuide())))
//	        		 							       )
//	        		 								 .list();  
	         
	         crit.add(Restrictions.eq("deleteStatus",false)); //by Huzong, updated on 07.08.2016
	         
	         crit.add(Restrictions.ne("userIntID",shallWaySearchDTO.getUserIntID()));
	         
	         crit.add(Restrictions.eq("country",shallWaySearchDTO.getCountry()))
				 .add(Restrictions.eq("province",shallWaySearchDTO.getProvince()))		
				 .add(Restrictions.eq("city",shallWaySearchDTO.getCity()));
	         
	         if(shallWaySearchDTO.getPlace()!=null){
	        	 crit.add(Restrictions.or(
					  Restrictions.like("place",shallWaySearchDTO.getPlace().trim(),MatchMode.ANYWHERE), 
					  Restrictions.isNull("place")));
	         }
	         
	         crit.add(Restrictions.and(
					  Restrictions.le("startTime", sdfd.parse(shallWaySearchDTO.getEndTime())),
					  Restrictions.ge("endTime", sdfd.parse(shallWaySearchDTO.getStartTime()))
					  ));
	         
	        Disjunction dj = Restrictions.disjunction();
        
	        if ("true".equalsIgnoreCase(shallWaySearchDTO.getCarPool())){
	        	dj.add(Restrictions.eq("carPool", Boolean.parseBoolean(shallWaySearchDTO.getCarPool())));
	        }
	        
	        if ("true".equalsIgnoreCase(shallWaySearchDTO.getFreeTour())){
	        	dj.add(Restrictions.eq("freeTour", Boolean.parseBoolean(shallWaySearchDTO.getFreeTour())));
	        }
	        
	        if ("true".equalsIgnoreCase(shallWaySearchDTO.getHotelShare())){
	        	dj.add(Restrictions.eq("hotelShare", Boolean.parseBoolean(shallWaySearchDTO.getHotelShare())));
	        }
	        
	        if ("true".equalsIgnoreCase(shallWaySearchDTO.getFreeGuide())){
	        	dj.add(Restrictions.eq("freeGuide", Boolean.parseBoolean(shallWaySearchDTO.getFreeGuide())));
	        }
	        
			crit.add(dj);
			crit.addOrder(Order.desc("postTime"));
			
			List<ShallWayOutDTO> shallWayList = crit.list();  	         
	         
		    shallWayArray = new ShallWayOutDTO[shallWayList.size()];
	            
		      if (shallWayList!=null && shallWayList.size()>0){
		    	  for (int i=0;i<shallWayList.size();i++){
		    		  shallWayArray[i] = shallWayList.get(i);
	    		  
		    		  blob = shallWayArray[i].getDescriptionBlob();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String description = new String(bdata);
					  shallWayArray[i].setDescriptionStr(description);

		    	  }
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
		public boolean updateShallWay (ShallWayUpdateDTO shallWayUpdateDTO) throws ParseException{	
			
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      boolean flag = false;
		      ShallWayEntity shallWayEntity = new ShallWayEntity();
		      Date postTime = new Date();
		      String dateID = shallWayUpdateDTO.getDateID();
		      String userIntID = shallWayUpdateDTO.getUserIntID();
		      SimpleDateFormat sdfd =new SimpleDateFormat("dd/MM/yyyy");

		      try{
		         tx = session.beginTransaction();
		         
			      String sql = "select * from shallway where dateID = ? and userIntID = ? and deletestatus = false";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, dateID);
			      query.setString(1, userIntID);
			      query.addEntity(ShallWayEntity.class);
			      
			      @SuppressWarnings("unchecked")
			      List<ShallWayEntity> shallWayList = query.list();	
			            
			      if (shallWayList!=null && shallWayList.size()>0)
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
			    	  String place = XssShieldUtil.stripXss(shallWayUpdateDTO.getPlace());
			    	  shallWayEntity.setPlace(place);
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getStartTime()!=null && !"".equals(shallWayUpdateDTO.getStartTime().trim())){
					  Date startTime =sdfd.parse(shallWayUpdateDTO.getStartTime());
			    	  shallWayEntity.setStartTime(startTime);
			    	  shallWayEntity.setPostTime(postTime);
			      }

			      if (shallWayUpdateDTO.getEndTime()!=null && !"".equals(shallWayUpdateDTO.getEndTime().trim())){
					  Date endTime =sdfd.parse(shallWayUpdateDTO.getEndTime());
			    	  shallWayEntity.setEndTime(endTime);
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getCarPool()!=null && !"".equals(shallWayUpdateDTO.getCarPool().trim())){
			    	  shallWayEntity.setCarPool(Boolean.parseBoolean(shallWayUpdateDTO.getCarPool()));
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getFreeTour()!=null && !"".equals(shallWayUpdateDTO.getFreeTour().trim())){
			    	  shallWayEntity.setFreeTour(Boolean.parseBoolean(shallWayUpdateDTO.getFreeTour()));
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getHotelShare()!=null && !"".equals(shallWayUpdateDTO.getHotelShare().trim())){
			    	  shallWayEntity.setHotelShare(Boolean.parseBoolean(shallWayUpdateDTO.getHotelShare()));
			    	  shallWayEntity.setPostTime(postTime);
			      }
	
			      if (shallWayUpdateDTO.getFreeGuide()!=null && !"".equals(shallWayUpdateDTO.getFreeGuide().trim())){
			    	  shallWayEntity.setFreeGuide(Boolean.parseBoolean(shallWayUpdateDTO.getFreeGuide()));
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getTitle()!=null && !"".equals(shallWayUpdateDTO.getTitle().trim())){
			    	  String title = XssShieldUtil.stripXss(shallWayUpdateDTO.getTitle());
			    	  shallWayEntity.setTitle(title);
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getContact()!=null && !"".equals(shallWayUpdateDTO.getContact().trim())){
			    	  String contact = XssShieldUtil.stripXss(shallWayUpdateDTO.getContact());
			    	  shallWayEntity.setContact(contact);
			    	  shallWayEntity.setPostTime(postTime);
			      }
			      
			      if (shallWayUpdateDTO.getDescriptionStr()!=null && !"".equals(shallWayUpdateDTO.getDescriptionStr().trim())){
			    	  String descriptionString = XssShieldUtil.stripXss(shallWayUpdateDTO.getDescriptionStr());
			    	  Blob description = Hibernate.getLobCreator(session).createBlob(descriptionString.getBytes());		         
			    	  shallWayEntity.setDescription(description);
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
			public void deleteShallWay (String dateID,String userIntID){
				
				  Session session = HibernateUtil.getSessionFactory().openSession();
			      Transaction tx = null;
			      ShallWayEntity shallWayEntity = new ShallWayEntity();

			      try{
			         tx = session.beginTransaction();
			         
				      String sql = "select * from shallway where dateID = ? and UserIntID = ?";
				      SQLQuery query = session.createSQLQuery(sql);
				      query.setString(0, dateID);
				      query.setString(1, userIntID);
				      query.addEntity(ShallWayEntity.class);
				      
				      @SuppressWarnings("unchecked")
				      List<ShallWayEntity> shallWayList = query.list();	
				      
				      if (shallWayList!=null && shallWayList.size()>0 ){
				    	  shallWayEntity = shallWayList.get(0);
				    	  shallWayEntity.setDeleteStatus(true);
				      }
			         session.update(shallWayEntity);
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }

				}	

}
