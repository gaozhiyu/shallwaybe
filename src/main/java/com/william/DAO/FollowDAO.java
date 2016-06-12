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
	public void addFollow(FollowInDTO followInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String id = UUID.randomUUID().toString().replaceAll("-", "");
	      FollowEntity followEntity = new FollowEntity();
	      Date followTime = new Date();	
	      
	      try{
		         tx = session.beginTransaction();

		         followEntity.setId(id);
		         followEntity.setDateID(followInDTO.getDateID());
		         followEntity.setFollowerIntID(followInDTO.getFollowerIntID());
		         followEntity.setFollowTime(followTime);
		         
		         session.save(followEntity);
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	}
	
	public FollowOutDTO[] readFollow(String dateID){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    FollowOutDTO[] followArray = null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select a.ID as id,a.DateID,a.FollowerIntID,a.FollowTime, b.Nickname as followerNickname from follow a join profile b on a.followerintid = b.userintid where a.dateID = ? order by followtime desc;";
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
	
	public void deleteFollow(String id){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      FollowEntity followEntity = new FollowEntity();

	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from follow where ID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, id);
//		      query.setString(1, userIntID);
		      query.addEntity(FollowEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<FollowEntity> followList = query.list();	
		      
		      if (followList!=null && followList.size()>0 )
		    	  followEntity = followList.get(0);
	            
	         session.delete(followEntity);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
		
	}

}
