package com.william.entity;

import java.util.Date;

public class LatestCoordinateEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userIntID;
	private double longitude;
	private double latitude;
	private Date lastShakeTime;
	private String country;
	private String province; 
	private String city;
	private Date lastAddressUpdate;  	
	
	public LatestCoordinateEntity() {
		super();
	}

	public LatestCoordinateEntity(String userIntID, double longitude, double latitude, Date lastShakeTime,
			String country, String province, String city, Date lastAddressUpdate) {
		super();
		this.userIntID = userIntID;
		this.longitude = longitude;
		this.latitude = latitude;
		this.lastShakeTime = lastShakeTime;
		this.country = country;
		this.province = province;
		this.city = city;
		this.lastAddressUpdate = lastAddressUpdate;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
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
