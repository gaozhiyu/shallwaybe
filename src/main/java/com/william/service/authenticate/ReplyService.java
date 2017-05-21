package com.william.service.authenticate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.william.DAO.ReplyDAO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;
import com.william.vo.ReplyVO;

public class ReplyService {
	
	public ReplyVO getReply(String dateID) throws SQLException{
		
		List<ReplyOutDTO> firstReplyList = new ArrayList<ReplyOutDTO>();
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		ReplyVO replyVO = new ReplyVO();
		ReplyOutDTO[] replyList = replyDAO.readReply(dateID);
		
		for (ReplyOutDTO reply:  replyList){
			if (reply.getSrcReplyID() == null){
				firstReplyList.add(reply);

			}
					
		}
		
		
		for (ReplyOutDTO reply2:  firstReplyList){
			
			String id = reply2.getId();
			List<ReplyOutDTO> secondReplyList = new ArrayList<ReplyOutDTO>();
			
			for (ReplyOutDTO reply3:  replyList){
				if ((""+id).equals(reply3.getSrcReplyID())){
					secondReplyList.add(reply3);
				}
				
			}
			
			ReplyOutDTO[] replyArray = new ReplyOutDTO[secondReplyList.size()];
			replyArray =  secondReplyList.toArray(replyArray);
 			
			reply2.setSbsqReplyArray(replyArray);
						
		}
		
		ReplyOutDTO[] replyVOArray = new ReplyOutDTO[firstReplyList.size()] ;
		replyVOArray = firstReplyList.toArray(replyVOArray);
		replyVO.setReplyArray(replyVOArray);
		
		return replyVO;
	
	
	}
	

}
