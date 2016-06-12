package com.william.to;

import java.util.Date;

public class ReplyInDTO {
	
	private String dateID;
    private String replierIntID;
	private String replyContents;
	
	public ReplyInDTO() {
		super();
	}

	public ReplyInDTO(String dateID, String replierIntID, String replyContents) {
		super();
		this.dateID = dateID;
		this.replierIntID = replierIntID;
		this.replyContents = replyContents;
	}

	public String getDateID() {
		return dateID;
	}

	public void setDateID(String dateID) {
		this.dateID = dateID;
	}

	public String getReplierIntID() {
		return replierIntID;
	}

	public void setReplierIntID(String replierIntID) {
		this.replierIntID = replierIntID;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
		
}
