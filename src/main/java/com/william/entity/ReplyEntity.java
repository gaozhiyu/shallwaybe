package com.william.entity;

import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;

public class ReplyEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private BigInteger sequenceID;
	private String id;
	private String dateID;
	private String srcReplyID;
	private String sourceUserIntID;
    private String replierIntID;
	private Date replyTime;
	private Blob replyContents;
	private Boolean deleteStatus;
	
	public ReplyEntity() {
		super();
	}
	
	public ReplyEntity(BigInteger sequenceID, String id, String dateID, String srcReplyID, String sourceUserIntID,
			String replierIntID, Date replyTime, Blob replyContents, Boolean deleteStatus) {
		super();
		this.sequenceID = sequenceID;
		this.id = id;
		this.dateID = dateID;
		this.srcReplyID = srcReplyID;
		this.sourceUserIntID = sourceUserIntID;
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

	public String getSrcReplyID() {
		return srcReplyID;
	}

	public void setSrcReplyID(String srcReplyID) {
		this.srcReplyID = srcReplyID;
	}
	
	public String getSourceUserIntID() {
		return sourceUserIntID;
	}

	public void setSourceUserIntID(String sourceUserIntID) {
		this.sourceUserIntID = sourceUserIntID;
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
