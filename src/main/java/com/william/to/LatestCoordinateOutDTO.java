package com.william.to;

import java.util.Date;

public class LatestCoordinateOutDTO {

	private String nickname;
	private String userIntID;
	private Double longitude;
	private Double latitude;
	private Date lastShakeTime;
	private String country;
	private String province; 
	private String city;
	private Date lastAddressUpdate;
		
	public LatestCoordinateOutDTO() {
		super();
	}

	public LatestCoordinateOutDTO(String nickname, String userIntID, Double longitude, Double latitude,
			Date lastShakeTime, String country, String province, String city, Date lastAddressUpdate) {
		super();
		this.nickname = nickname;
		this.userIntID = userIntID;
		this.longitude = longitude;
		this.latitude = latitude;
		this.lastShakeTime = lastShakeTime;
		this.country = country;
		this.province = province;
		this.city = city;
		this.lastAddressUpdate = lastAddressUpdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Date getLastShakeTime() {
		return lastShakeTime;
	}

	public void setLastShakeTime(Date lastShakeTime) {
		this.lastShakeTime = lastShakeTime;
	}

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

	public Date getLastAddressUpdate() {
		return lastAddressUpdate;
	}

	public void setLastAddressUpdate(Date lastAddressUpdate) {
		this.lastAddressUpdate = lastAddressUpdate;
	}
	
}
