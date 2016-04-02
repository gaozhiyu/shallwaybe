package com.william.to;

public class ShakeInDTO {

	private String username;
	private String latitude;
	private String longitude;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "ShakeInDTO [username=" + username + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	

}
