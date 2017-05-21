package com.william.DAO;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.william.entity.FollowEntity;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;
import com.william.to.ShallWayOutDTO;
import com.william.util.HibernateUtil;

public class MyFollowDAO {
	
	private static MyFollowDAO instance;
	
	private final int pageSize = 1;
	
	public static MyFollowDAO getInstance() {
		if (instance == null) {
			instance = new MyFollowDAO();
		}
		return instance;
	}
	
	public String addMyFollow(FollowInDTO followInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String id = UUID.randomUUID().toString().replaceAll("-", "");
	      FollowEntity followEntity = new FollowEntity();
	      Date followTime = new Date();	
	      String followID =null;
	      
	      try{
		         tx = session.beginTransaction();

		         followEntity.setId(id);
		         followEntity.setDateID(followInDTO.getDateID());
		         followEntity.setFollowerIntID(followInDTO.getFollowerIntID());
		         followEntity.setFollowTime(followTime);
		         followEntity.setDeleteStatus(false);
		         
		         session.save(followEntity);
		         tx.commit();
		         followID = id;
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	      return followID;
	}
	

	// return a list of my followed shallway
	public ShallWayOutDTO[] readMyFollowList(String userIntID, int pageNumber) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ShallWayOutDTO[] followArray = null;
	    byte[] bdata= null;
	    Blob blob=null;	  
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select b.* from follow a join shallwayview b on a.dateID = b.dateID where a.followerintid = ? and a.deletestatus = false order by followtime desc";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, userIntID);
		      query.addEntity(ShallWayOutDTO.class);
		      
		      query.setFirstResult((pageNumber-1) * pageSize);
		      query.setMaxResults(pageSize);
		      
//		      query.setResultTransformer(Transformers.aliasToBean(ShallWayOutDTO.class));
		     
		      List<ShallWayOutDTO> followList = query.list();	
		      
		      followArray = new ShallWayOutDTO[followList.size()];
	    	  
		      if (followList!=null && followList.size()>0 ){
		    	  for (int i=0;i<followList.size();i++){
		    		  followArray[i] = followList.get(i);
		    		  
		    		  blob = followArray[i].getDescriptionBlob();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String description = new String(bdata);
					  followArray[i].setDescriptionStr(description);
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return followArray;
		
	}
	
	// return whether this shallway is followed by me, 15.01.2017
	public FollowEntity readMyFollowStatus(FollowInDTO followInDTO){

		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      FollowEntity followEntity = null;
	      String dateID = followInDTO.getDateID();
	      String userIntID = followInDTO.getFollowerIntID();
//	      boolean flag = false;
	      
	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from follow where DateID = ? and FollowerIntID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, dateID);
		      query.setString(1, userIntID);
		      query.addEntity(FollowEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<FollowEntity> followList = query.list();	
		      
		      if (followList!=null && followList.size()>0 ){
		    	  followEntity = followList.get(0);

		      }
  

	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
	      
	      return followEntity;
	}
	
	// Re-follow or Delete, flag= flase to re-follow, flag= true to delete
		public void updateFollow(FollowInDTO followInDTO, boolean flag){
			
			  Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      FollowEntity followEntity = new FollowEntity();
		      Date followTime = new Date();	

		      try{
		         tx = session.beginTransaction();
		         

			      String sql = "select * from follow where dateid = ? and followerintid =?";
			      SQLQuery query = session.createSQLQuery(sql);
			      query.setString(0, followInDTO.getDateID());
			      query.setString(1, followInDTO.getFollowerIntID());
			      query.addEntity(FollowEntity.class);
			      
			      @SuppressWarnings("unchecked")
			      List<FollowEntity> followList = query.list();	
			      
			      if (followList!=null && followList.size()>0 ){
			    	  followEntity = followList.get(0);
			    	  followEntity.setDeleteStatus(flag);
			    	  
			    	  if (flag==false){
			    		  followEntity.setFollowTime(followTime);
			    	  }
			      }
		         session.update(followEntity);
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }		
			
		}	

}
