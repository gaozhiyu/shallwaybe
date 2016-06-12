package com.william.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.william.DAO.MessageDAO;
import com.william.to.MessageInDTO;
import com.william.to.MessageOutDTO;

public class TestMessage {

	MessageDAO messageDAO = new MessageDAO();
	MessageOutDTO[] messageArray = null;
	MessageInDTO messageInDTO = new MessageInDTO("Hello,我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어","001","201");
	

	
	@Ignore
	@Test
	public void testRetrieveMessage() throws SQLException{
		
//	messageDAO.addMessage(messageInDTO);
	messageArray = messageDAO.retrieveMessage("201");
	for (int i=0;i< messageArray.length;i++){
		System.out.println();
		System.out.println(messageArray[i].getMessageID());
		System.out.println(messageArray[i].getMessageContents());
		System.out.println(messageArray[i].getSenderIntID());
		System.out.println(messageArray[i].getSendTime());
		
		assertEquals("Hello,我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어", messageArray[i].getMessageContents());
		
	}
//	assertEquals(1, messageArray.length);
	
	}
	
	@Test
	public void testUpdateMessageSendStatus(){
		boolean flag=messageDAO.updateMessageSendStatus("0637778999174d049ec626cf947edaa3");
		assertEquals(true,flag);
		
	}
}
