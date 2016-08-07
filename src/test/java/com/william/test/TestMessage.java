package com.william.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.william.DAO.MessageDAO;
import com.william.to.MessageInDTO;
import com.william.to.MessageOutDTO;

public class TestMessage {

	MessageDAO messageDAO = MessageDAO.getInstance();//MessageDAO messageDAO =new MessageDAO();
	MessageOutDTO[] messageArray = null;
	MessageInDTO messageInDTO = new MessageInDTO("Hello,我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어,欧了","100","胡总","001");
//  Hello,我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어

	@Test	
	public void testAddMessage(){
		messageDAO.addMessage(messageInDTO);		
	}
	
	@Test
	public void testRetrieveMessage() throws SQLException{
		
	messageArray = messageDAO.retrieveMessage("001");
	for (int i=0;i< messageArray.length;i++){
		System.out.println();
		System.out.println(messageArray[i].getMessageID());
		System.out.println(messageArray[i].getMessageContents());
		System.out.println(messageArray[i].getSenderIntID());
		System.out.println(messageArray[i].getSenderNickname());
		System.out.println(messageArray[i].getSendTime());
		
	}	
	}
	
//	@Ignore
	@Test
	public void testUpdateMessageSendStatus(){
		boolean flag=messageDAO.updateMessageSendStatus("6f9a2abd17834857b33aecf5535e610c");
		assertEquals(true,flag);
		
	}
}
