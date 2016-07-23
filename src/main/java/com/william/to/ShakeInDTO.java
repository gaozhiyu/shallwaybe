package com.william.to;

import com.william.vo.CommonInput;

public class ShakeInDTO extends CommonInput{

	//private String userid;
	private String latitude;
	private String longitude;

	

	public ShakeInDTO() {
		//super();
	}


	public ShakeInDTO(String userIntID, String latitude, String longitude) {
		//super();
		this.setUserIntID(userIntID);
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ShakeInDTO [username=" + this.getUserIntID() + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	

}
