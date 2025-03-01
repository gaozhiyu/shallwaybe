package com.william.to;

import java.sql.Blob;
import java.util.Date;

import org.hibernate.type.TextType;

public class MessageOutDTO {

	private String messageID;
	private String messageContentsStr;
	private String senderIntID;
	private String senderNickname;
	private Date sendTime;
	private Blob messageContents;
	//TODO HZ add the nickname here
	
	public MessageOutDTO() {
		super();
	}

	public MessageOutDTO(String messageID, String messageContents, String senderIntID, String senderNickname,
			Date sendTime) {
		super();
		this.messageID = messageID;
		this.messageContentsStr = messageContents;
		this.senderIntID = senderIntID;
		this.senderNickname = senderNickname;
		this.sendTime = sendTime;
	}


	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getMessageContentsStr() {
		return messageContentsStr;
	}

	public void setMessageContentsStr(String messageContents) {
		this.messageContentsStr = messageContents;
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Blob getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(Blob messageContents) {
		this.messageContents = messageContents;
	}	
	
}
