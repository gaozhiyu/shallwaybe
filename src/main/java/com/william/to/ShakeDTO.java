package com.william.to;

import com.william.vo.CommonInput;

public class ShakeDTO extends CommonInput{

	//private String username;
	private String distance;
	private String shakeTime;
	//private String userid;
	private String nickname;
	private String signature;
	


	public ShakeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ShakeDTO(String distance, String shakeTime,
			String userIntID, String nickname, String signature) {
		super();
		
		this.distance = distance;
		this.shakeTime = shakeTime;
		this.setUserIntID(userIntID);
		this.nickname = nickname;
		this.signature = signature;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getSignature() {
		return signature;
	}



	public void setSignature(String signature) {
		this.signature = signature;
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
