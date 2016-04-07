package com.william.to;

import java.util.Date;

public class LatestCoordinateInDTO {
	
	private String shallWayID;
	private Double longitude;
	private Double latitude;
//	private Date lastShakeTime;
	private String country;
	private String province; 
	private String city;
//	private Date lastAddressUpdate;
	
	public LatestCoordinateInDTO() {
		super();
	}
	
	public LatestCoordinateInDTO(String shallWayID, Double longitude, Double latitude,
			String country, String province, String city) {
		super();
		this.shallWayID = shallWayID;
		this.longitude = longitude;
		this.latitude = latitude;
//		this.lastShakeTime = lastShakeTime;
		this.country = country;
		this.province = province;
		this.city = city;
	}

	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
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
