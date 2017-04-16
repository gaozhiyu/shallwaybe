package com.william.to;

import java.util.Date;

public class BlackListOutDTO {
	
	private String entryID;
	private String userIntID;
    private String blockUserIntID;
    private String blockUserNickname;
	private Boolean deleteStatus;
	private Date createTime;
	private Date updateTime;
	
	public BlackListOutDTO() {
		super();
	}

	public BlackListOutDTO(String entryID, String userIntID, String blockUserIntID, String blockUserNickname,
			Boolean deleteStatus, Date createTime, Date updateTime) {
		super();
		this.entryID = entryID;
		this.userIntID = userIntID;
		this.blockUserIntID = blockUserIntID;
		this.blockUserNickname = blockUserNickname;
		this.deleteStatus = deleteStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getEntryID() {
		return entryID;
	}

	public void setEntryID(String entryID) {
		this.entryID = entryID;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public String getBlockUserIntID() {
		return blockUserIntID;
	}

	public void setBlockUserIntID(String blockUserIntID) {
		this.blockUserIntID = blockUserIntID;
	}

	public String getBlockUserNickname() {
		return blockUserNickname;
	}

	public void setBlockUserNickname(String blockUserNickname) {
		this.blockUserNickname = blockUserNickname;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}
