package com.william.entity;

import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;

public class ReplyEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private BigInteger sequenceID;
	private String id;
	private String dateID;
    private String replierIntID;
	private Date replyTime;
	private Blob replyContents;
	private Boolean deleteStatus;
	
	public ReplyEntity() {
		super();
	}

	public ReplyEntity(String id, String dateID, String replierIntID, Date replyTime, Blob replyContents,
			Boolean deleteStatus) {
		super();
		this.id = id;
		this.dateID = dateID;
		this.replierIntID = replierIntID;
		this.replyTime = replyTime;
		this.replyContents = replyContents;
		this.deleteStatus = deleteStatus;
	}
	
	public BigInteger getSequenceID() {
		return sequenceID;
	}

	public void setSequenceID(BigInteger sequenceID) {
		this.sequenceID = sequenceID;
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

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Blob getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(Blob replyContents) {
		this.replyContents = replyContents;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	
		
}
