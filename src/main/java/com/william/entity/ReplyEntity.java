package com.william.entity;

import java.util.Date;

public class ReplyEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String shallWayID;
	private String authorIntID;
	private String authorNickname;
    private String replierIntID;
	private String replierNickname;
	private Date replyTime;
	private String replyContents;
	
	public ReplyEntity() {
		super();
	}

	public ReplyEntity(String id, String shallWayID, String authorIntID, String authorNickname, String replierIntID,
			String replierNickName, Date replyTime, String replyContents) {
		super();
		this.id = id;
		this.shallWayID = shallWayID;
		this.authorIntID = authorIntID;
		this.authorNickname = authorNickname;
		this.replierIntID = replierIntID;
		this.replierNickname = replierNickName;
		this.replyTime = replyTime;
		this.replyContents = replyContents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
	}

	public String getAuthorIntID() {
		return authorIntID;
	}

	public void setAuthorIntID(String authorIntID) {
		this.authorIntID = authorIntID;
	}


	public String getAuthorNickname() {
		return authorNickname;
	}

	public void setAuthorNickname(String authorNickname) {
		this.authorNickname = authorNickname;
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
