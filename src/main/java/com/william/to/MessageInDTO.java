package com.william.to;

import java.sql.Blob;

public class MessageInDTO {

//	private String messageID;
	private String messageContents;
	private String senderIntID;
	private String receiverIntID;
//	private String sendStatus;
	
	public MessageInDTO() {
		super();
	}


	public MessageInDTO(String messageContents, String senderIntID, String receiverIntID) {
		super();
//		this.messageID = messageID;
		this.messageContents = messageContents;
		this.senderIntID = senderIntID;
		this.receiverIntID = receiverIntID;
//		this.sendStatus = sendStatus;
	}

//	public String getMessageID() {
//		return messageID;
//	}
//
//	public void setMessageID(String messageID) {
//		this.messageID = messageID;
//	}

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

	public String getReceiverIntID() {
		return receiverIntID;
	}

	public void setReceiverIntID(String receiverIntID) {
		this.receiverIntID = receiverIntID;
	}


//	public String getSendStatus() {
//		return sendStatus;
//	}
//
//
//	public void setSendStatus(String sendStatus) {
//		this.sendStatus = sendStatus;
//	}
	
	
	
}
