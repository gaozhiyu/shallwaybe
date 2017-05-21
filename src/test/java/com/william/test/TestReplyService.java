package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.service.authenticate.ReplyService;
import com.william.to.ReplyOutDTO;
import com.william.vo.ReplyVO;

public class TestReplyService {
	
	ReplyService replyService = new ReplyService();
	ReplyVO replyVO =null;
	ReplyOutDTO[] replyArray= null;
	ReplyOutDTO[] replySubArray= null;
	
	
	@Test 
	public void testGetReplyService() throws SQLException{
		
		replyVO = replyService.getReply("807d4160db5c4822990d1047753515d2");
		replyArray = replyVO.getReplyArray();
		
		System.out.println("Array Length: "+replyArray.length);
				
		for(int i=0; i<replyArray.length;i++){
			System.out.println();
			System.out.println("ID: "+replyArray[i].getId());
			System.out.println("DateID: "+replyArray[i].getDateID());
			System.out.println("SrcReplyID: "+replyArray[i].getSrcReplyID());
			System.out.println("SourceUserIntID: "+replyArray[i].getSourceUserIntID());
			System.out.println("SourceUserNickname: "+replyArray[i].getSourceUserNickname());
			System.out.println("ReplierIntID: "+replyArray[i].getReplierIntID());
			System.out.println("ReplierNickname: " + replyArray[i].getReplierNickname());
			System.out.println("ReplyTime: "+replyArray[i].getReplyTime());
			System.out.println("ReplyContents: "+replyArray[i].getReplyContentsStr());
			System.out.println("DeleteStatus: "+replyArray[i].getDeleteStatus());
			
			replySubArray = replyArray[i].getSbsqReplyArray();
			
			for(int j=0; j<replySubArray.length;j++){
				System.out.println();
				System.out.println("\tID: "+replySubArray[j].getId());
				System.out.println("\tDateID: "+replySubArray[j].getDateID());
				System.out.println("\tSrcReplyID: "+replySubArray[j].getSrcReplyID());
				System.out.println("\tSourceUserIntID: "+replySubArray[j].getSourceUserIntID());
				System.out.println("\tSourceUserNickname: "+replySubArray[j].getSourceUserNickname());
				System.out.println("\tReplierIntID: "+replySubArray[j].getReplierIntID());
				System.out.println("\tReplierNickname: " + replySubArray[j].getReplierNickname());
				System.out.println("\tReplyTime: "+replySubArray[j].getReplyTime());
				System.out.println("\tReplyContents: "+replySubArray[j].getReplyContentsStr());
				System.out.println("\tDeleteStatus: "+replySubArray[j].getDeleteStatus());						
				
			}
			
		}	
		
	}

}
