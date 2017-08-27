package com.william.to;

import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReplyOutDTO{
	
	private BigInteger sequenceID;
	private String id;
	private String dateID;
	private String mainUserIntID;
	private String srcReplyID;
	private String sourceUserIntID;
	private String sourceUserNickname;
    private String replierIntID;
    private String replierNickname;
	private Date replyTime;
	private String replyContentsStr;
	private transient Blob replyContents;
	private Boolean deleteStatus;
	private Boolean mainUserPushStatus;
	private Date mainUserPushTime;
	private Boolean sourceUserPushStatus;
	private Date sourceUserPushTime;
	private ReplyOutDTO[] sbsqReplyArray;
	
	
	public ReplyOutDTO[] getSbsqReplyArray() {
		return sbsqReplyArray;
	}

	public void setSbsqReplyArray(ReplyOutDTO[] sbsqReplyArray) {
		this.sbsqReplyArray = sbsqReplyArray;
	}

	public ReplyOutDTO(BigInteger sequenceID, String id, String dateID, String mainUserIntID, String srcReplyID,
			String sourceUserIntID, String sourceUserNickname, String replierIntID, String replierNickname,
			Date replyTime, String replyContentsStr, Blob replyContents, Boolean deleteStatus,
			Boolean mainUserPushStatus, Date mainUserPushTime, Boolean sourceUserPushStatus, Date sourceUserPushTime) {
		super();
		this.sequenceID = sequenceID;
		this.id = id;
		this.dateID = dateID;
		this.mainUserIntID = mainUserIntID;
		this.srcReplyID = srcReplyID;
		this.sourceUserIntID = sourceUserIntID;
		this.sourceUserNickname = sourceUserNickname;
		this.replierIntID = replierIntID;
		this.replierNickname = replierNickname;
		this.replyTime = replyTime;
		this.replyContentsStr = replyContentsStr;
		this.replyContents = replyContents;
		this.deleteStatus = deleteStatus;
		this.mainUserPushStatus = mainUserPushStatus;
		this.mainUserPushTime = mainUserPushTime;
		this.sourceUserPushStatus = sourceUserPushStatus;
		this.sourceUserPushTime = sourceUserPushTime;
	}

	public ReplyOutDTO() {
		super();
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

	public String getMainUserIntID() {
		return mainUserIntID;
	}

	public void setMainUserIntID(String mainUserIntID) {
		this.mainUserIntID = mainUserIntID;
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
	
	

	public String getSourceUserNickname() {
		return sourceUserNickname;
	}



	public void setSourceUserNickname(String sourceUserNickname) {
		this.sourceUserNickname = sourceUserNickname;
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

	
	public String getReplyContentsStr() {
		return replyContentsStr;
	}

	public void setReplyContentsStr(String replyContentsStr) {
		this.replyContentsStr = replyContentsStr;
	}

	@JsonIgnore
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

	public Boolean getMainUserPushStatus() {
		return mainUserPushStatus;
	}

	public void setMainUserPushStatus(Boolean mainUserPushStatus) {
		this.mainUserPushStatus = mainUserPushStatus;
	}

	public Date getMainUserPushTime() {
		return mainUserPushTime;
	}

	public void setMainUserPushTime(Date mainUserPushTime) {
		this.mainUserPushTime = mainUserPushTime;
	}

	public Boolean getSourceUserPushStatus() {
		return sourceUserPushStatus;
	}

	public void setSourceUserPushStatus(Boolean sourceUserPushStatus) {
		this.sourceUserPushStatus = sourceUserPushStatus;
	}

	public Date getSourceUserPushTime() {
		return sourceUserPushTime;
	}

	public void setSourceUserPushTime(Date sourceUserPushTime) {
		this.sourceUserPushTime = sourceUserPushTime;
	}
	
}
