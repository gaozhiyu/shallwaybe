package com.william.to;

public class RigsterOutDTO {

	private String registerStatus;
	private String ShallwayId;
	private String userId;//email Address
	
	
	public String getRegisterStatus() {
		return registerStatus;
	}
	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
	public String getShallwayId() {
		return ShallwayId;
	}
	public void setShallwayId(String shallwayId) {
		ShallwayId = shallwayId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
