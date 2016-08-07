package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;

public class TestReply {
	
	ReplyDAO replyDAO = new ReplyDAO();
	ReplyOutDTO[] replyArray= null;

	ReplyInDTO replyInDTO = new ReplyInDTO("05488c398929403ca5b019c0629075de","9d39464ce8ce43a597acfe5e43c1c523","我勒去，可以吗!");
	
	@Test
	public void testAddReply(){
		replyDAO.addReply(replyInDTO);		
	}
	
	@Test
	public void testReadReply() throws SQLException{
		
		replyArray = replyDAO.readReply("05488c398929403ca5b019c0629075de");
		
		for(int i=0; i<replyArray.length;i++){
			System.out.println();
			System.out.println("ID: "+replyArray[i].getId());
			System.out.println("\tDateID: "+replyArray[i].getDateID());
			System.out.println("\tReplierIntID: "+replyArray[i].getReplierIntID());
			System.out.println("\tReplierNickname: " + replyArray[i].getReplierNickname());
			System.out.println("\tReplyTime: "+replyArray[i].getReplyTime());
			System.out.println("\tReplyContents: "+replyArray[i].getReplyContentsStr());
			System.out.println("\tDeleteStatus: "+replyArray[i].getDeleteStatus());
		}		
	}
	
	@Test
	public void testDeleteReply(){
		replyDAO.deleteReply("02ce7612d94e459f976fe2e64712e685");		
	}
	
}
