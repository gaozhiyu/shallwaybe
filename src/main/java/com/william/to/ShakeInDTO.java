package com.william.to;

public class ShakeInDTO {

	private String userid;
	private String latitude;
	private String longitude;


	public String getUserid() {
		return userid;
	}

	public ShakeInDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShakeInDTO(String userid, String latitude, String longitude) {
		super();
		this.userid = userid;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
		return "ShakeInDTO [username=" + userid + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	

}
