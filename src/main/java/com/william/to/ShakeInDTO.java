package com.william.to;

import com.william.vo.CommonInput;

public class ShakeInDTO extends CommonInput{

	//private String userid;
	private double latitude;
	private double longitude;
	private int shakeType;

	

	public int getShakeType() {
		return shakeType;
	}


	public void setShakeType(int shakeType) {
		this.shakeType = shakeType;
	}


	public ShakeInDTO() {
		//super();
	}


	public ShakeInDTO(String userIntID, double latitude, double longitude) {
		//super();
		this.setUserIntID(userIntID);
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ShakeInDTO [username=" + this.getUserIntID() + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	

}
