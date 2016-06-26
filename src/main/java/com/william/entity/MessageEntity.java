package com.william.entity;

import java.sql.Blob;
import java.util.Date;

public class MessageEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String messageID;
	private Blob messageContents;
	private String senderIntID;
	private String senderNickname;
	private String receiverIntID;
	private Date sendTime;
	private Boolean sendStatus;
		
	public MessageEntity() {
		super();
	}



	public MessageEntity(String messageID, Blob messageContents, String senderIntID, String senderNickname,
			String receiverIntID, Date sendTime, Boolean sendStatus) {
		super();
		this.messageID = messageID;
		this.messageContents = messageContents;
		this.senderIntID = senderIntID;
		this.senderNickname = senderNickname;
		this.receiverIntID = receiverIntID;
		this.sendTime = sendTime;
		this.sendStatus = sendStatus;
	}



	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public Blob getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(Blob messageContents) {
		this.messageContents = messageContents;
	}

	public String getSenderIntID() {
		return senderIntID;
	}

	public void setSenderIntID(String senderIntID) {
		this.senderIntID = senderIntID;
	}

	
	public String getSenderNickname() {
		return senderNickname;
	}



	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}



	public String getReceiverIntID() {
		return receiverIntID;
	}

	public void setReceiverIntID(String receiverIntID) {
		this.receiverIntID = receiverIntID;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Boolean getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Boolean sendStatus) {
		this.sendStatus = sendStatus;
	}
		
}
