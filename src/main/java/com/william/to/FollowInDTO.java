package com.william.to;

import java.util.Date;

public class FollowInDTO{
	
	private String dateID;
    private String followerIntID;
	private boolean targetStatus;
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

	public boolean isTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(boolean targetStatus) {
		this.targetStatus = targetStatus;
	}




	
	
}
