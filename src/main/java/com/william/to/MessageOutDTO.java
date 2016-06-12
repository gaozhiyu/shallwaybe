package com.william.to;

import java.sql.Blob;
import java.util.Date;

import org.hibernate.type.TextType;

public class MessageOutDTO {

	private String messageID;
	private String messageContents;
	private String senderIntID;
	private Date sendTime;
	
	public MessageOutDTO() {
		super();
	}

	public MessageOutDTO(String messageID, String messageContents, String senderIntID, Date sendTime) {
		super();
		this.messageID = messageID;
		this.messageContents = messageContents;
		this.senderIntID = senderIntID;
		this.sendTime = sendTime;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	
}
