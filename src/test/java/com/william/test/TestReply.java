package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;

public class TestReply {
	
	ReplyDAO replyDAO = new ReplyDAO();
	ReplyOutDTO[] replyArray= null;

	ReplyInDTO replyInDTO = new ReplyInDTO("807d4160db5c4822990d1047753515d2","07d407cf02154d8f814c099cb0301c16","1ec66787b52542b29fbc7b6beef16926","dab4dbe204294a368fc3c30cb7f479a3","07d407cf02154d8f814c099cb0301c16","我来看啊可能");
	
	@Test
	public void testAddReply(){
		replyDAO.addReply(replyInDTO);		
	}
	
	@Test
	public void testReadReply() throws SQLException{
		ReplyOutDTO[] replyArray= null;
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
	public void TestPushReplyToMainUser() throws SQLException{
		ReplyOutDTO[] replyArray= null;
		replyArray=replyDAO.pushReplyToMainUser("07d407cf02154d8f814c099cb0301c16");
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
	public void TestPushReplyToSourceUser() throws SQLException{
		ReplyOutDTO[] replyArray= null;
		replyArray=replyDAO.pushReplyToSourceUser("07d407cf02154d8f814c099cb0301c16");
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
		replyDAO.deleteReply("3dac862edf424f59bcaad0296ca7eaf6");		
	}
	
	@Test
	public void testMainUserPushStatus(){
		replyDAO.updateMainUserPushStatus("85453236628b4cab878a067b69064e59", false);
	}
	
	@Test
	public void testSourceUserPushStatus(){
		replyDAO.updateSourceUserPushStatus("98f13be942874e54bc62798afda4482c", false);
	}
	

	
}
