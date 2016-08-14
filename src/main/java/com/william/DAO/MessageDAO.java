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
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.william.entity.MessageEntity;
import com.william.to.MessageInDTO;
import com.william.to.MessageOutDTO;
import com.william.util.HibernateUtil;
import com.william.util.MessageQueue;
import com.william.util.XssShieldUtil;

public class MessageDAO {
	
	private static MessageDAO instance;
	
	public static MessageDAO getInstance() {
		if (instance == null) {
			instance = new MessageDAO();
		}
		return instance;
	}
	
	public void addMessage(MessageInDTO messageInDTO){
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      String messageID = UUID.randomUUID().toString().replaceAll("-", "");
	      MessageEntity messageEntity = new MessageEntity();
	      Date sendTime = new Date();	
	      Blob messageContents;
	    		  
	      try{
		         tx = session.beginTransaction();

		         messageEntity.setMessageID(messageID);
		         
		         String messageContentsString = XssShieldUtil.stripXss(messageInDTO.getMessageContents());
		         messageContents = Hibernate.getLobCreator(session).createBlob(messageContentsString.getBytes());
		         messageEntity.setMessageContents(messageContents);
		         
		         messageEntity.setSenderIntID(messageInDTO.getSenderIntID());
		         messageEntity.setSenderNickname(messageInDTO.getSenderNickname());
		         messageEntity.setReceiverIntID(messageInDTO.getReceiverIntID());
		         messageEntity.setSendTime(sendTime);
		         messageEntity.setSendStatus(false);
		         
		         session.save(messageEntity);
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }	
	}
	
	/*read message when user is online*/
	public MessageOutDTO[] retrieveMessage(String receiverIntID) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    MessageOutDTO[] messageArray = null;
		byte[] bdata= null;
		Blob blob=null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select * from message where ReceiverIntID = ? and SendStatus = false order by sendtime asc;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, receiverIntID);
		      query.addScalar("MessageID", new StringType());
		      query.addScalar("MessageContents", new BlobType());
		      query.addScalar("SendTime", new TimestampType());
		      query.addScalar("SenderIntID", new StringType());
		      query.addScalar("SenderNickname", new StringType());
		      query.setResultTransformer(Transformers.aliasToBean(MessageOutDTO.class));
		      
		      @SuppressWarnings("unchecked")
			  List<MessageOutDTO> messageList = query.list();	
		      messageArray = new MessageOutDTO[messageList.size()];
	    	  
		      if (messageList!=null && messageList.size()>0 ){
		    	  for (int i=0;i<messageList.size();i++){
		    		  messageArray[i] = messageList.get(i);
		    		  
		    		  blob = messageArray[i].getMessageContents();
		    		  bdata = blob.getBytes(1, (int) blob.length());
					  String messageContents = new String(bdata);
					  messageArray[i].setMessageContentsStr(messageContents);			  
		    	  }	    	    
		      }
		      	      	          		      
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return messageArray;	
		
	}
	
	/*update message send status: read-true; not yet read-false*/
//	public boolean updateMessage(MessageInDTO messageInDTO){
	public boolean updateMessageSendStatus(String messageID){		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    Boolean flag =false;
	    MessageEntity messageEntity = new MessageEntity();
//	    String messageID = messageInDTO.getMessageID();
	    
	    try{
		      tx = session.beginTransaction();
		      
		      String sql = "select * from message where MessageID = ?";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, messageID);
		      query.addEntity(MessageEntity.class);	
		      
		      @SuppressWarnings("unchecked")
			  List<MessageEntity> messageList = query.list();	
		      	    	  
		      if (messageList!=null && messageList.size()>0){
		    	  messageEntity = messageList.get(0);
		      }
		      		      
		      messageEntity.setSendStatus(true);
		      
		      session.update(messageEntity);
		      
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
