package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;

public class TestReply {
	
	ReplyDAO replyDAO = new ReplyDAO();
	ReplyOutDTO[] replyArray= null;

	ReplyInDTO replyInDTO = new ReplyInDTO("807d4160db5c4822990d1047753515d2","1ec66787b52542b29fbc7b6beef16926","dab4dbe204294a368fc3c30cb7f479a3","07d407cf02154d8f814c099cb0301c16","我是Tester1，我在回复 测试员4");
	
	@Test
	public void testAddReply(){
		replyDAO.addReply(replyInDTO);		
	}
	
	@Test
	public void testReadReply() throws SQLException{
		
		replyArray = replyDAO.readReply("807d4160db5c4822990d1047753515d2");
		
		for(int i=0; i<replyArray.length;i++){
			System.out.println();
			System.out.println("ID: "+replyArray[i].getId());
			System.out.println("\tDateID: "+replyArray[i].getDateID());
			System.out.println("\tSrcReplyID: "+replyArray[i].getSrcReplyID());
			System.out.println("\tSourceUserIntID: "+replyArray[i].getSourceUserIntID());
			System.out.println("\tSourceUserNickname: "+replyArray[i].getSourceUserNickname());
			System.out.println("\tReplierIntID: "+replyArray[i].getReplierIntID());
			System.out.println("\tReplierNickname: " + replyArray[i].getReplierNickname());
			System.out.println("\tReplyTime: "+replyArray[i].getReplyTime());
			System.out.println("\tReplyContents: "+replyArray[i].getReplyContentsStr());
			System.out.println("\tDeleteStatus: "+replyArray[i].getDeleteStatus());
		}		
	}
	
	@Test
	public void testDeleteReply(){
		replyDAO.deleteReply("ee9c58b1915d46f5a00b193e7d425542");		
	}
	

	
}
