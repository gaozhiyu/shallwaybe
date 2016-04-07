package com.william.to;

import java.util.Date;

public class AddressHistoryInDTO{
	
	private String shallWayID;
	private String country;
	private String province;
	private String city;
//	private Date updateTime;
	private String placeType;/*R for register address, B for been address*/
	
	public AddressHistoryInDTO() {
	}

	public AddressHistoryInDTO(String shallWayID, String country, String province, String city,
			String placeType) {
		this.shallWayID = shallWayID;
		this.country = country;
		this.province=province;
		this.city = city;
		this.placeType = placeType;
	}

	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
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

//	public Date getUpdateTime() {
//		return updateTime;
//	}
//
//	public void setUpdateTime(Date updateTime) {
//		this.updateTime = updateTime;
//	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

}
