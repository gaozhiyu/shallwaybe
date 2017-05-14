package com.william.DAO;

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
import com.william.util.HibernateUtil;

public class FollowDAO {
	
	private static FollowDAO instance;
	
	public static FollowDAO getInstance() {
		if (instance == null) {
			instance = new FollowDAO();
		}
		return instance;
	}
	
	public String addFollow(FollowInDTO followInDTO){
		
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
	
	public FollowOutDTO[] readFollow(String dateID){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    FollowOutDTO[] followArray = null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select a.id as id,a.dateid,a.followerintid,a.followtime,a.deletestatus, b.nickname as followerNickname from follow a join profile b on a.followerintid = b.userintid where a.dateid = ? and a.deletestatus =false order by followtime desc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, dateID);
		      query.setResultTransformer(Transformers.aliasToBean(FollowOutDTO.class));
		      List<FollowOutDTO> followList = query.list();	
		      followArray = new FollowOutDTO[followList.size()];
	    	  
		      if (followList!=null && followList.size()>0 ){
		    	  for (int i=0;i<followList.size();i++){
		    		  followArray[i] = followList.get(i);
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

// Check if I followed this Shallway Record and then un-followed before. If yes, go to UpdateFollow to follow it again, otherwise go to AddFollow to follow it, 14/5/2017
	public boolean readFollow(FollowInDTO followInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      FollowEntity followEntity = new FollowEntity();
	      boolean flag =false;
	      
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
		    	  flag = true;

		      }
	         session.update(followEntity);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
	      
	      return flag;
		
	}
	
// Re-follow on shallway record	
	public void updateFollow(FollowInDTO followInDTO){
		
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
		    	  followEntity.setDeleteStatus(false);
		    	  followEntity.setFollowTime(followTime);
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
	
	
	public void deleteFollow(FollowInDTO followInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      FollowEntity followEntity = new FollowEntity();

	      try{
	         tx = session.beginTransaction();
	         
//		      String sql = "select * from follow where id = ?";
		      String sql = "select * from follow where dateid = ? and followerintid =?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, followInDTO.getDateID());
		      query.setString(1, followInDTO.getFollowerIntID());
		      query.addEntity(FollowEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<FollowEntity> followList = query.list();	
		      
		      if (followList!=null && followList.size()>0 ){
		    	  followEntity = followList.get(0);
		    	  followEntity.setDeleteStatus(true);
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
