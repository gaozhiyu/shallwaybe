package com.william.DAO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.william.entity.BlackListEntity;
import com.william.to.BlackListInDTO;
import com.william.to.BlackListOutDTO;
import com.william.to.FollowOutDTO;
import com.william.util.HibernateUtil;

public class BlackListDAO {
	
	private static BlackListDAO instance;
	
	public static BlackListDAO getInstance() {
		if (instance == null) {
			instance = new BlackListDAO();
		}
		return instance;
	}
	
	public void addBlackList(BlackListInDTO blackListInDTO){

		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String entryID = UUID.randomUUID().toString().replaceAll("-", "");
	      BlackListEntity blackListEntity = new BlackListEntity();
	      Date currentTime = new Date();	
	      
	      try{
		         tx = session.beginTransaction();

		         blackListEntity.setEntryID(entryID);
		         blackListEntity.setUserIntID(blackListInDTO.getUserIntID());
		         blackListEntity.setBlockUserIntID(blackListInDTO.getBlockUserIntID());
		         blackListEntity.setDeleteStatus(false); // false means blocked user still in the black list
		         blackListEntity.setCreateTime(currentTime);
		         blackListEntity.setUpdateTime(currentTime);
	         
		         session.save(blackListEntity);
		         
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }			
	}
	
	public BlackListOutDTO[] readBlackList(String userIntID){

		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    BlackListOutDTO[] blackListArray = null;
	    
	    try{
		      tx = session.beginTransaction();

//		      String sql = "select a.id as id,a.dateid,a.followerintid,a.followtime,a.deletestatus, b.nickname as followerNickname from follow a join profile b on a.followerintid = b.userintid where a.dateid = ? and a.deletestatus =false order by followtime desc;";
//		      String sql = "select a.entryid as entryID, a.userintid as userIntID, a.blockuserintid as blockUserIntID,a.deleteStatus,a.createTime,a.updateTime, b.nickname as blockUserNickname from blacklist a join profile b on a.blockuserintid = b.userintid where a.userintid = ? and a.deletestatus =false order by updatetime desc;";
		      String sql = "select a.entryID, a.userIntID, a.blockUserIntID,a.deleteStatus,a.createTime,a.updateTime, b.nickname as blockUserNickname from blacklist a join profile b on a.blockuserintid = b.userintid where a.userintid = ? and a.deletestatus =false order by updatetime desc;";

		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, userIntID);
		      query.setResultTransformer(Transformers.aliasToBean(BlackListOutDTO.class));
		      @SuppressWarnings("unchecked")
			  List<BlackListOutDTO> blackList = query.list();	
		      blackListArray = new BlackListOutDTO[blackList.size()];
	    	  
		      if (blackList!=null && blackList.size()>0 ){
		    	  for (int i=0;i<blackList.size();i++){
		    		  blackListArray[i] = blackList.get(i);
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return blackListArray;		
	
	}
	
	// check if the blockuser was already in my blacklist, if already in blacklist, go to updateblacklist, otherwise, go to addblacklist
	public boolean readBlackList(String userIntID, String blockUserIntID){

		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      BlackListEntity blackListEntity = new BlackListEntity();
	      boolean flag =false;
	      
	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from blacklist where userintid = ? and blockuserintid = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, userIntID);
		      query.setString(1, blockUserIntID);
		      query.addEntity(BlackListEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<BlackListEntity> blackList = query.list();	
		      
		      if (blackList!=null && blackList.size()>0 ){
		    	  blackListEntity = blackList.get(0);
		    	  flag =true;
		      }    	  
		      
	         session.update(blackListEntity);
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }			
		
	      return flag;
	}
	
	// re-add those who have been deleted from blacklist previously
	public void updateBlackList(String userIntID, String blockUserIntID){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      BlackListEntity blackListEntity = new BlackListEntity();
	      Date currentTime = new Date();
	      
	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from blacklist where userintid = ? and blockuserintid = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, userIntID);
		      query.setString(1, blockUserIntID);
		      query.addEntity(BlackListEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<BlackListEntity> blackList = query.list();	
		      
		      if (blackList!=null && blackList.size()>0 ){
		    	  blackListEntity = blackList.get(0);
		    	  blackListEntity.setDeleteStatus(false);
		    	  blackListEntity.setUpdateTime(currentTime);
		      }
		      
	         session.update(blackListEntity);
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }						
	}
	
	public void deleteBlackList(String userIntID, String blockUserIntID){

		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      BlackListEntity blackListEntity = new BlackListEntity();

	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from blacklist where userintid = ? and blockuserintid = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, userIntID);
		      query.setString(1, blockUserIntID);
		      query.addEntity(BlackListEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<BlackListEntity> blackList = query.list();	
		      
		      if (blackList!=null && blackList.size()>0 ){
		    	  blackListEntity = blackList.get(0);
		    	  blackListEntity.setDeleteStatus(true);
		      }
		      
	         session.update(blackListEntity);
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }					
	}

}
