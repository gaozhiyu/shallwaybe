package com.william.to;

import java.sql.Blob;
import java.util.Date;

public class MessageConvertDTO {

	private String messageID;
	private Blob messageContents;
	private String senderIntID;
	private String senderNickname;
	private Date sendTime;
	
	public MessageConvertDTO() {
		super();
	}

	public MessageConvertDTO(String messageID, Blob messageContents, String senderIntID, String senderNickname,
			Date sendTime) {
		super();
		this.messageID = messageID;
		this.messageContents = messageContents;
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	
}
