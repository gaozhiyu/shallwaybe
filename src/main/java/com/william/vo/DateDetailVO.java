package com.william.vo;

import com.william.to.ReplyOutDTO;
import com.william.to.ShallWayOutDTO;

public class DateDetailVO extends CommonVO{
	private ShallWayOutDTO dateDetails;
//	private ReplyOutDTO[] replyList;
	private boolean followFlag;

	public ShallWayOutDTO getDateDetails() {
		return dateDetails;
	}
	public void setDateDetails(ShallWayOutDTO dateDetails) {
		this.dateDetails = dateDetails;
	}
//	public ReplyOutDTO[] getReplyList() {
//		return replyList;
//	}
//	public void setReplyList(ReplyOutDTO[] replyList) {
//		this.replyList = replyList;
//	}
	public boolean isFollowFlag() {
		return followFlag;
	}
	public void setFollowFlag(boolean followFlag) {
		this.followFlag = followFlag;
	}
	
	
	
	
}
