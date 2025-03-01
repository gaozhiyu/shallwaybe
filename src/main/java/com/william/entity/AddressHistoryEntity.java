package com.william.entity;

import java.util.Date;

public class AddressHistoryEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userIntID;
	private String addressSequenceID;	
	private String country;
	private String province;
	private String city;
	private Date updateTime;
	private String placeType;/*R for register address, B for been address*/
	
	public AddressHistoryEntity() {
		super();
	}

	public AddressHistoryEntity(String userIntID, String addressSequenceID, String country,
			String province, String city, Date updateTime, String placeType) {
		super();
		this.userIntID = userIntID;
		this.addressSequenceID = addressSequenceID;
		this.country = country;
		this.province = province;
		this.city = city;
		this.updateTime = updateTime;
		this.placeType = placeType;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public String getAddressSequenceID() {
		return addressSequenceID;
	}

	public void setAddressSequenceID(String addressSequenceID) {
		this.addressSequenceID = addressSequenceID;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

}
