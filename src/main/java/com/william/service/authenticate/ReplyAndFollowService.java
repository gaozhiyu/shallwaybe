package com.william.service.authenticate;

import com.william.DAO.FollowDAO;
import com.william.DAO.MyFollowDAO;
import com.william.DAO.ReplyDAO;
import com.william.entity.FollowEntity;
import com.william.to.FollowInDTO;
import com.william.to.ReplyInDTO;
import com.william.vo.CommonVO;

public class ReplyAndFollowService {

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
	
	
}
