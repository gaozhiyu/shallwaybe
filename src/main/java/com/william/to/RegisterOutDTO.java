package com.william.to;

public class RegisterOutDTO {

	private String registerStatus;
	private String shallwayID;
	private String userID;//email Address
	
	
	public String getRegisterStatus() {
		return registerStatus;
	}
	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
	public String getShallwayID() {
		return shallwayID;
	}
	public void setShallwayID(String shallwayId) {
		shallwayID = shallwayId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userId) {
		this.userID = userId;
	}
	
	
	
}
