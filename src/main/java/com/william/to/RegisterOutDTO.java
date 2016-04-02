package com.william.to;

public class RegisterOutDTO extends CommonDTO{

	private String registerStatus;
	private String shallwayID;
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
	public String getShallwayID() {
		return shallwayID;
	}
	public void setShallwayID(String shallwayId) {
		shallwayID = shallwayId;
	}
	
	
	
}
