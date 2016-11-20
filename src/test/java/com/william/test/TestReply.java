package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;

public class TestReply {
	
	ReplyDAO replyDAO = new ReplyDAO();
	ReplyOutDTO[] replyArray= null;

	ReplyInDTO replyInDTO = new ReplyInDTO("94ab4fbd272b43d2beed7688345f5fa3","b53a45037c244371baaeb5e7af75aa90","我勒去，可以吗!");
	
	@Test
	public void testAddReply(){
		replyDAO.addReply(replyInDTO);		
	}
	
	@Test
	public void testReadReply() throws SQLException{
		
		replyArray = replyDAO.readReply("94ab4fbd272b43d2beed7688345f5fa3");
		
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
		replyDAO.deleteReply("fe99d5d1b3ce4efb8ab3c425bf86a806");		
	}
	
}
