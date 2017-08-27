package com.william.DAO;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BlobType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.william.entity.ReplyEntity;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;
import com.william.util.HibernateUtil;
import com.william.util.XssShieldUtil;

public class ReplyDAO {
	
	private static ReplyDAO instance;
	
	public static ReplyDAO getInstance() {
		if (instance == null) {
			instance = new ReplyDAO();
		}
		return instance;
	}
	
	public void addReply(ReplyInDTO replyInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String id = UUID.randomUUID().toString().replaceAll("-", "");
	      ReplyEntity replyEntity = new ReplyEntity();
	      Date currentTime = new Date();	
	      
	      try{
		         tx = session.beginTransaction();

		         replyEntity.setId(id);
		         replyEntity.setDateID(replyInDTO.getDateID());
		         
		         replyEntity.setMainUserIntID(replyInDTO.getMainUserIntID());
		         
		         replyEntity.setSrcReplyID(replyInDTO.getSrcReplyID());
		         replyEntity.setSourceUserIntID(replyInDTO.getSourceUserIntID());
		         replyEntity.setReplierIntID(replyInDTO.getReplierIntID());
		         replyEntity.setReplyTime(currentTime);
		         
		         String replyContentsString = XssShieldUtil.stripXss(replyInDTO.getReplyContents());
		         Blob replyContents = Hibernate.getLobCreator(session).createBlob(replyContentsString.getBytes());		         
		         replyEntity.setReplyContents(replyContents);
		         
		         replyEntity.setDeleteStatus(false);
		         
		         replyEntity.setMainUserPushStatus(true);
		         replyEntity.setMainUserPushTime(currentTime);
		         replyEntity.setSourceUserPushStatus(true);
		         replyEntity.setSourceUserPushTime(currentTime);
		         
		         session.save(replyEntity);
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }		
	}
	
	public ReplyOutDTO[] readReply(String dateID) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ReplyOutDTO[] replyArray = null;
	    byte[] bdata= null;
	    Blob blob=null;
	      
	    try{
		      tx = session.beginTransaction();

//		      String sql = "select a.ID as id,a.DateID,a.ReplierIntID,a.ReplyTime,a.ReplyContents, b.Nickname as replierNickname from reply a join profile b on a.replierintid = b.userintid where a.dateID = ? order by replytime desc;";
//		      String sql = "select a.*, b.Nickname as replierNickname from reply a join profile b on a.replierintid = b.userintid where a.dateID = ? and a.deletestatus = false order by replytime asc;";
		      String sql = "select a.*, getNickname(a.sourceUserIntID) as sourceUserNickname, getNickname(a.replierintid) as replierNickname from reply a where a.dateID = ? and a.deletestatus = false order by replytime asc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, dateID);
		      query.addScalar("id", new StringType());
		      query.addScalar("DateID", new StringType());
		      query.addScalar("MainUserIntID", new StringType());
		      query.addScalar("SrcReplyID", new StringType());
		      query.addScalar("SourceUserIntID", new StringType());		      
		      query.addScalar("SourceUserNickname", new StringType());
		      query.addScalar("ReplierIntID", new StringType());
		      query.addScalar("ReplyTime", new TimestampType());
		      query.addScalar("replierNickname", new StringType());
		      query.addScalar("ReplyContents", new BlobType());
		      query.addScalar("DeleteStatus", new BooleanType());
		      query.addScalar("MainUserPushStatus", new BooleanType());
		      query.addScalar("MainUserPushTime", new TimestampType());
		      query.addScalar("SourceUserPushStatus", new BooleanType());
		      query.addScalar("SourceUserPushTime", new TimestampType());
		      
		      query.setResultTransformer(Transformers.aliasToBean(ReplyOutDTO.class));
		      List<ReplyOutDTO> replyList = query.list();	
		      replyArray = new ReplyOutDTO[replyList.size()];
	    	  
		      if (replyList!=null && replyList.size()>0){
		    	  for (int i=0;i<replyList.size();i++){
		    		  replyArray[i] = replyList.get(i);
		    		  
 		    		  blob = replyArray[i].getReplyContents();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String replyContents = new String(bdata);
					  replyArray[i].setReplyContentsStr(replyContents);
					  
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return replyArray;		
		
	}
	
	public void deleteReply(String id){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      ReplyEntity replyEntity = new ReplyEntity();

	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from reply where ID = ?";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, id);
//		      query.setString(1, userIntID);
		      query.addEntity(ReplyEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ReplyEntity> replyList = query.list();	
		      
		      if (replyList!=null && replyList.size()>0 ){
		    	  replyEntity = replyList.get(0);
		    	  replyEntity.setDeleteStatus(true);
		      }
		      
	         session.update(replyEntity);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }		
		
	}
	
	public ReplyOutDTO[] pushReplyToMainUser(String mainUserIntID) throws SQLException{ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ReplyOutDTO[] replyArray = null;
	    byte[] bdata= null;
	    Blob blob=null;
	      
	    try{
		      tx = session.beginTransaction();

		      String sql = "select a.*, getNickname(a.sourceUserIntID) as sourceUserNickname, getNickname(a.replierintid) as replierNickname from reply a where a.mainuserintid = ? and a.deletestatus = false and a.mainuserpushstatus =false order by replytime asc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, mainUserIntID);
		      query.addScalar("id", new StringType());
		      query.addScalar("DateID", new StringType());
		      query.addScalar("MainUserIntID", new StringType());
		      query.addScalar("SrcReplyID", new StringType());
		      query.addScalar("SourceUserIntID", new StringType());		      
		      query.addScalar("SourceUserNickname", new StringType());
		      query.addScalar("ReplierIntID", new StringType());
		      query.addScalar("ReplyTime", new TimestampType());
		      query.addScalar("replierNickname", new StringType());
		      query.addScalar("ReplyContents", new BlobType());
		      query.addScalar("DeleteStatus", new BooleanType());
		      query.addScalar("MainUserPushStatus", new BooleanType());
		      query.addScalar("MainUserPushTime", new TimestampType());
		      query.addScalar("SourceUserPushStatus", new BooleanType());
		      query.addScalar("SourceUserPushTime", new TimestampType());
		      
		      query.setResultTransformer(Transformers.aliasToBean(ReplyOutDTO.class));
		      List<ReplyOutDTO> replyList = query.list();	
		      replyArray = new ReplyOutDTO[replyList.size()];
	    	  
		      if (replyList!=null && replyList.size()>0){
		    	  for (int i=0;i<replyList.size();i++){
		    		  replyArray[i] = replyList.get(i);
		    		  
 		    		  blob = replyArray[i].getReplyContents();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String replyContents = new String(bdata);
					  replyArray[i].setReplyContentsStr(replyContents);
					  
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return replyArray;	
	}

	public ReplyOutDTO[] pushReplyToSourceUser(String sourceUserIntID) throws SQLException{ 
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    ReplyOutDTO[] replyArray = null;
	    byte[] bdata= null;
	    Blob blob=null;
	      
	    try{
		      tx = session.beginTransaction();

		      String sql = "select a.*, getNickname(a.sourceUserIntID) as sourceUserNickname, getNickname(a.replierintid) as replierNickname from reply a where a.sourceuserintid = ? and a.deletestatus = false  and a.sourceuserpushstatus = false order by replytime asc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, sourceUserIntID);
		      query.addScalar("id", new StringType());
		      query.addScalar("DateID", new StringType());
		      query.addScalar("MainUserIntID", new StringType());
		      query.addScalar("SrcReplyID", new StringType());
		      query.addScalar("SourceUserIntID", new StringType());		      
		      query.addScalar("SourceUserNickname", new StringType());
		      query.addScalar("ReplierIntID", new StringType());
		      query.addScalar("ReplyTime", new TimestampType());
		      query.addScalar("replierNickname", new StringType());
		      query.addScalar("ReplyContents", new BlobType());
		      query.addScalar("DeleteStatus", new BooleanType());
		      query.addScalar("MainUserPushStatus", new BooleanType());
		      query.addScalar("MainUserPushTime", new TimestampType());
		      query.addScalar("SourceUserPushStatus", new BooleanType());
		      query.addScalar("SourceUserPushTime", new TimestampType());
		      
		      query.setResultTransformer(Transformers.aliasToBean(ReplyOutDTO.class));
		      List<ReplyOutDTO> replyList = query.list();	
		      replyArray = new ReplyOutDTO[replyList.size()];
	    	  
		      if (replyList!=null && replyList.size()>0){
		    	  for (int i=0;i<replyList.size();i++){
		    		  replyArray[i] = replyList.get(i);
		    		  
 		    		  blob = replyArray[i].getReplyContents();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String replyContents = new String(bdata);
					  replyArray[i].setReplyContentsStr(replyContents);
					  
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return replyArray;	
	}
	
	public boolean updateMainUserPushStatus(String id, Boolean status){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Boolean flag =false;
	      ReplyEntity replyEntity = new ReplyEntity();
	      Date currentTime = new Date();

	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from reply where ID = ? and deletestatus =false";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, id);
//		      query.setString(1, userIntID);
		      query.addEntity(ReplyEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ReplyEntity> replyList = query.list();	
		      
		      if (replyList!=null && replyList.size()>0 ){
		    	  replyEntity = replyList.get(0);
		    	  replyEntity.setMainUserPushStatus(status);
		    	  replyEntity.setMainUserPushTime(currentTime);
		      }
		      
	         session.update(replyEntity);
	         tx.commit();
	         flag=true;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }	
	      
	      return flag;
	}
	
	public boolean updateSourceUserPushStatus(String id, Boolean status){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Boolean flag =false;
	      ReplyEntity replyEntity = new ReplyEntity();
	      Date currentTime = new Date();

	      try{
	         tx = session.beginTransaction();
	         
		      String sql = "select * from reply where ID = ? and deletestatus =false";
		      SQLQuery query = session.createSQLQuery(sql);
		      query.setString(0, id);
//		      query.setString(1, userIntID);
		      query.addEntity(ReplyEntity.class);
		      
		      @SuppressWarnings("unchecked")
		      List<ReplyEntity> replyList = query.list();	
		      
		      if (replyList!=null && replyList.size()>0 ){
		    	  replyEntity = replyList.get(0);
		    	  replyEntity.setSourceUserPushStatus(status);
		    	  replyEntity.setSourceUserPushTime(currentTime);
		      }
		      
	         session.update(replyEntity);
	         tx.commit();
	         flag=true;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }	
	      
	      return flag;
	}

}
