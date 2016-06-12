package com.william.to;

import java.util.Date;

public class ProfileReadDTO {
	private String shallWayID;
	private String email;
	private String password;
	private String nickname;
	private String gender;
	private Date dateOfBirth;
	private String country;
	private String province;
	private String city;
	private String googleCountry;
	private String googleProvince;
	private String googleCity;
	private Double longitude;
	private Double latitude;	
	private Date lastUpdate; 
	private Date createTime;   
	private Date lastAddressUpdate;  	
	private String status;
	
	public ProfileReadDTO() {
		super();
	}

	public String getShallWayID() {
		return shallWayID;
	}

	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
	public String getGoogleCountry() {
		return googleCountry;
	}

	public void setGoogleCountry(String googleCountry) {
		this.googleCountry = googleCountry;
	}

	public String getGoogleProvince() {
		return googleProvince;
	}

	public void setGoogleProvince(String googleProvince) {
		this.googleProvince = googleProvince;
	}

	public String getGoogleCity() {
		return googleCity;
	}

	public void setGoogleCity(String googleCity) {
		this.googleCity = googleCity;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastAddressUpdate() {
		return lastAddressUpdate;
	}

	public void setLastAddressUpdate(Date lastAddressUpdate) {
		this.lastAddressUpdate = lastAddressUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
