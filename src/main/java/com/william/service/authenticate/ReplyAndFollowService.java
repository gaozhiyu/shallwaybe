package com.william.service.authenticate;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.william.DAO.FollowDAO;
import com.william.DAO.MyFollowDAO;
import com.william.DAO.ReplyDAO;
import com.william.DAO.ShallWayDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.entity.FollowEntity;
import com.william.to.DateInDTO;
import com.william.to.FollowInDTO;
import com.william.to.ReplyInDTO;
import com.william.to.ReplyOutDTO;
import com.william.to.ShallWayOutDTO;
import com.william.vo.CommonVO;
import com.william.vo.DateDetailVO;
import com.william.vo.ReplyVO;

public class ReplyAndFollowService {
	
	private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

	public CommonVO addDateReply(ReplyInDTO inDTO){
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		CommonVO cvo = new CommonVO();
		if(!inDTO.isValid()){
			cvo.setStatus("N");
			return cvo;
		}
		replyDAO.addReply(inDTO);
		
		cvo.setStatus("Y");
		return cvo;
	}
	
	public CommonVO toggleFollowDate(FollowInDTO inDTO){
		CommonVO commonVO = new CommonVO();
		//FollowDAO followDAO = FollowDAO.getInstance();
		MyFollowDAO myFollowDAO = MyFollowDAO.getInstance();
		boolean flag = false;
		if(inDTO.isTargetStatus()){
			FollowInDTO followInDTO = new FollowInDTO(inDTO.getDateID(),inDTO.getFollowerIntID());
			FollowEntity followEntity = myFollowDAO.readMyFollowStatus(followInDTO);
			if(followEntity!=null){
				myFollowDAO.updateFollow(followInDTO,false);//update the deletestatus to false
			}else{
				myFollowDAO.addMyFollow(followInDTO);
			}
			flag = true;
		}else {
			myFollowDAO.updateFollow(inDTO, true);//update the deletestatus to true
			flag = true;
		}
		if(flag){
			commonVO.setStatus("Y");
		} else {
			commonVO.setStatus("N");
		}
		
		return commonVO;
	}
	

	
public ReplyVO getDateAndReply(DateInDTO inDTO) throws SQLException{
		
		//inDTO.setProvince(inDTO.getCity().substring(0, 1));//TODO change in future
		ReplyVO replyVO = new ReplyVO();
		ShallWayDAO msw= ShallWayDAO.getInstance();
		ShallWayOutDTO dateVO=msw.retrieveDateByDateID(inDTO.getDateid());
		
		dateVO.setStartTimeStr(df.format(dateVO.getStartTime()));
		dateVO.setEndTimeStr(df.format(dateVO.getEndTime()));
		replyVO.setDateDetails(dateVO);
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		ReplyOutDTO[] replyList = getReply(inDTO.getDateid());
		replyVO.setReplyArray(replyList);
		replyVO.setStatus("Y");
		return replyVO;
	}
	
	
private ReplyOutDTO[] getReply(String dateID) throws SQLException{
		
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
		return replyVOArray;
	}
	
	
}
