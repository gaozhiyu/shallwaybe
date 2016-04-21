package com.william.to;

public class RegisterOutDTO extends CommonDTO{

	private String registerStatus;
	private String userIntID;
	//private String userID;//email Address
	private String nickname;
	//private String status;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegisterStatus() {
		return registerStatus;
	}
	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
	public String getUserIntID() {
		return userIntID;
	}
	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

}
