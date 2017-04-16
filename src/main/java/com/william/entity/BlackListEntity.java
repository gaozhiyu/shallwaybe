package com.william.entity;

import java.util.Date;

public class BlackListEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String entryID;
	private String userIntID;
    private String blockUserIntID;
	private Boolean deleteStatus;
	private Date createTime;
	private Date updateTime;
	
	
	public BlackListEntity() {
		super();
	}

	public BlackListEntity(String entryID, String userintID, String blockUserIntID, Boolean deleteStatus,
			Date createTime, Date updateTime) {
		super();
		this.entryID = entryID;
		this.userIntID = userintID;
		this.blockUserIntID = blockUserIntID;
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
