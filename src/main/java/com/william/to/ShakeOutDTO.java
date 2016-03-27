package com.william.to;

public class ShakeOutDTO {

	private String username;
	private String distance;
	private String shakeTime;
	


	public ShakeOutDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShakeOutDTO(String username, String distance, String shakeTime) {
		super();
		this.username = username;
		this.distance = distance;
		this.shakeTime = shakeTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getShakeTime() {
		return shakeTime;
	}

	public void setShakeTime(String shakeTime) {
		this.shakeTime = shakeTime;
	}

	
	

}
