package com.william.to;

import java.util.Date;

public class FollowInDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String dateID;
    private String followerIntID;
	
	public FollowInDTO() {
		super();
	}

	public FollowInDTO(String dateID, String followerIntID) {
		super();
		this.dateID = dateID;
		this.followerIntID = followerIntID;
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
	
}
