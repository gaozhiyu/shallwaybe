package com.william.to;

public class RegisterOutDTO {

	private String registerStatus;
	private String shallwayID;
	private String userID;//email Address
	private String nickname;
	private String status;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
