package com.william.test;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;

public class ReplyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplyDAO replyDAO = new ReplyDAO();
		ReplyOutDTO[] replyArray= null;

		ReplyInDTO replyInDTO = new ReplyInDTO("5b3ad3653abf47729f5147405e16bead","30ce9dc77809415e897c1af0f5660b6e","约吗!");
		
//		replyDAO.addReply(replyInDTO);
		
		replyArray = replyDAO.readReply("5b3ad3653abf47729f5147405e16bead");
		
		for(int i=0; i<replyArray.length;i++){
			System.out.println();
			System.out.println("ID: "+replyArray[i].getId());
			System.out.println("\tDateID: "+replyArray[i].getDateID());
			System.out.println("\tReplierIntID: "+replyArray[i].getReplierIntID());
			System.out.println("\tReplierNickname: " + replyArray[i].getReplierNickname());
			System.out.println("\tReplyTime: "+replyArray[i].getReplyTime());
			System.out.println("\tReplyContents: "+replyArray[i].getReplyContents());
		}
		
//		replyDAO.deleteReply("ca41a022a4b44646af66492629fc3605");
	}

}
