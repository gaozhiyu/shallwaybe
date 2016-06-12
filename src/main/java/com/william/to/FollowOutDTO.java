package com.william.to;

import java.util.Date;

public class FollowOutDTO{
	
	private String id;
	private String dateID;
    private String followerIntID;
    private String followerNickname;
	private Date followTime;
	
	public FollowOutDTO() {
		super();
	}


	public FollowOutDTO(String id, String dateID, String followerIntID, String followerNickname, Date followTime) {
		super();
		this.id = id;
		this.dateID = dateID;
		this.followerIntID = followerIntID;
		this.followerNickname = followerNickname;
		this.followTime = followTime;
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


	public String getFollowerNickname() {
		return followerNickname;
	}


	public void setFollowerNickname(String followerNickname) {
		this.followerNickname = followerNickname;
	}
	
	
}
