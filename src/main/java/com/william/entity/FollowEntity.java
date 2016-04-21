package com.william.entity;

import java.util.Date;

public class FollowEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String shallWayID;
	private String authorIntID;
	private String authorNickname;
    private String followerIntID;
	private String followerNickname;
	private Date followTime;
	
	public FollowEntity() {
		super();
	}

	public FollowEntity(String id, String shallWayID, String authorIntID, String authorNickname, String followerIntID,
			String followerNickname, Date followTime) {
		super();
		this.id = id;
		this.shallWayID = shallWayID;
		this.authorIntID = authorIntID;
		this.authorNickname = authorNickname;
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

	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
	}

	public String getAuthorIntID() {
		return authorIntID;
	}

	public void setAuthorIntID(String authorIntID) {
		this.authorIntID = authorIntID;
	}

	public String getAuthorNickname() {
		return authorNickname;
	}

	public void setAuthorNickname(String authorNickname) {
		this.authorNickname = authorNickname;
	}

	public String getFollowerIntID() {
		return followerIntID;
	}

	public void setFollowerIntID(String followerIntID) {
		this.followerIntID = followerIntID;
	}

	public String getFollowerNickname() {
		return followerNickname;
	}

	public void setFollowerNickname(String followerNickname) {
		this.followerNickname = followerNickname;
	}

	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	
	
}
