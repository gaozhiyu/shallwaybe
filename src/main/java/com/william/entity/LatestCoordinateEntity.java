package com.william.entity;

import java.util.Date;

public class LatestCoordinateEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shallWayID;
	private String nickName;
	private Double longitude;
	private Double latitude;
	private Date lastShakeTime;
	private String country;
	private String province; 
	private String city;
	private Date lastAddressUpdate;  	
	
	public LatestCoordinateEntity() {
		super();
	}



	public LatestCoordinateEntity(String shallWayID, String nickName, Double longitude, Double latitude,
			Date lastShakeTime, String country, String province, String city, Date lastAddressUpdate) {
		super();
		this.shallWayID = shallWayID;
		this.nickName = nickName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.lastShakeTime = lastShakeTime;
		this.country = country;
		this.province = province;
		this.city = city;
		this.lastAddressUpdate = lastAddressUpdate;
	}



	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
	}

		
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
