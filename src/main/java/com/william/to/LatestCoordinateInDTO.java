package com.william.to;


public class LatestCoordinateInDTO {
	
	private String userIntID;
	private String longitude;
	private String latitude;
//	private Date lastShakeTime;
	private String country;
	private String province; 
	private String city;
//	private Date lastAddressUpdate;
	
	public LatestCoordinateInDTO() {
		super();
	}
	
	public LatestCoordinateInDTO(String userIntID, String longitude, String latitude, String country,
		String province, String city) {
	super();
	this.userIntID = userIntID;
	this.longitude = longitude;
	this.latitude = latitude;
	this.country = country;
	this.province = province;
	this.city = city;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

//	public Date getLastShakeTime() {
//		return lastShakeTime;
//	}
//
//	public void setLastShakeTime(Date lastShakeTime) {
//		this.lastShakeTime = lastShakeTime;
//	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
