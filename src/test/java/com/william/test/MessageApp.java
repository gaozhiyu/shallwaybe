package com.william.test;


import java.sql.Blob;
import java.sql.SQLException;

import com.william.DAO.MessageDAO;
import com.william.to.MessageConvertDTO;
import com.william.to.MessageInDTO;
import com.william.to.MessageOutDTO;

public class MessageApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MessageDAO  MSG = new MessageDAO();
//		MessageConvertDTO[] messageArray = null;
		MessageOutDTO[] messageArray = null;
		byte[] bdata= null;
		Blob blob=null;
		
		MessageInDTO messageInDTO = new MessageInDTO("Hello,我嘞个去，தமிழ்,にほんご,हिन्दी或हिंदी,한국어","001","105");
		MSG.addMessage(messageInDTO);
		
		messageArray =  MSG.retrieveMessage("105");
		
		for (int i=0;i< messageArray.length;i++){
			System.out.println();
			System.out.println(messageArray[i].getMessageID());
			System.out.println(messageArray[i].getMessageContents());
//			blob= messageArray[i].getMessageContents();
//			bdata = blob.getBytes(1, (int) blob.length());
//			String messageContents = new String(bdata);
//			System.out.println(messageContents);
			System.out.println(messageArray[i].getSenderIntID());
			System.out.println(messageArray[i].getSendTime());
			
		}
		
//		MSG.updateMessageSendStatus("d12c3f91609f49f78667a6f331be5f9b");

	}

}
