package com.william.vo;

import com.william.to.ReplyOutDTO;
import com.william.to.ShallWayOutDTO;

public class ReplyVO extends CommonVO{
	
	private ReplyOutDTO[] replyArray;
	private ShallWayOutDTO dateDetails;
	
	

	public ShallWayOutDTO getDateDetails() {
		return dateDetails;
	}

	public void setDateDetails(ShallWayOutDTO dateDetails) {
		this.dateDetails = dateDetails;
	}

	public ReplyOutDTO[] getReplyArray() {
		return replyArray;
	}

	public void setReplyArray(ReplyOutDTO[] replyArray) {
		this.replyArray = replyArray;
	}
	
	

}
