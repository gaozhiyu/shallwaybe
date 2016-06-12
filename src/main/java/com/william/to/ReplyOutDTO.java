package com.william.to;

import java.util.Date;

public class ReplyOutDTO{
	
	private String id;
	private String dateID;
    private String replierIntID;
    private String replierNickname;
	private Date replyTime;
	private String replyContents;
	
	public ReplyOutDTO() {
		super();
	}

	public ReplyOutDTO(String id, String dateID, String replierIntID, String replierNickname, Date replyTime,
			String replyContents) {
		super();
		this.id = id;
		this.dateID = dateID;
		this.replierIntID = replierIntID;
		this.replierNickname = replierNickname;
		this.replyTime = replyTime;
		this.replyContents = replyContents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getReplierNickname() {
		return replierNickname;
	}

	public void setReplierNickname(String replierNickname) {
		this.replierNickname = replierNickname;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
		
}
