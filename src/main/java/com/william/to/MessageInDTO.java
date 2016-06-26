package com.william.to;

import java.sql.Blob;

public class MessageInDTO {

//	private String messageID;
	private String messageContents;
	private String senderIntID;
	private String senderNickname;
	private String receiverIntID;
//	private String sendStatus;
	
	public MessageInDTO() {
		super();
	}

public MessageInDTO(String messageContents, String senderIntID, String senderNickname, String receiverIntID) {
	super();
	this.messageContents = messageContents;
	this.senderIntID = senderIntID;
	this.senderNickname = senderNickname;
	this.receiverIntID = receiverIntID;
}

	public String getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(String messageContents) {
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
	
	
}
