package com.william.entity;

import java.util.Date;

public class FollowEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String dateID;
    private String followerIntID;
	private Date followTime;
	private Boolean deleteStatus;
	
	public FollowEntity() {
		super();
	}

	public FollowEntity(String id, String dateID, String followerIntID, Date followTime, Boolean deleteStatus) {
		super();
		this.id = id;
		this.dateID = dateID;
		this.followerIntID = followerIntID;
		this.followTime = followTime;
		this.deleteStatus = deleteStatus;
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

	public String getFollowerIntID() {
		return followerIntID;
	}

	public void setFollowerIntID(String followerIntID) {
		this.followerIntID = followerIntID;
	}

	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
}
