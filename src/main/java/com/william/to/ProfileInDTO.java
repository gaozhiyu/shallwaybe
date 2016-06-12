package com.william.to;

import java.util.Date;

public class ProfileInDTO {

	private String userIntID;
	private String email;
	private String password;
	private String nickname;
	private String gender;
	private String dateOfBirth;
	private String country;
	private String province;
	private String city;
	private String googleCountry;
	private String googleProvince;
	private String googleCity;
	private String longitude;
	private String latitude;	
//	private Date lastUpdate; 
//	private Date createTime;   
//	private Date lastAddressUpdate;  	
	private String signature;
	
	public ProfileInDTO() {
		super();
	}

	public ProfileInDTO(String userIntID, String email, String password, String nickname, String gender,
			String dateOfBirth, String country, String province, String city, String gCountry, String gProvince,
			String gCity, String longitude, String latitude, String signature) {
		super();
		this.userIntID = userIntID;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.province = province;
		this.city = city;
		this.googleCountry = gCountry;
		this.googleProvince = gProvince;
		this.googleCity = gCity;
		this.longitude = longitude;
		this.latitude = latitude;
		this.signature = signature;
	}


	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
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
//	public Date getLastUpdate() {
//		return lastUpdate;
//	}
//	public void setLastUpdate(Date lastUpdate) {
//		this.lastUpdate = lastUpdate;
//	}
//	public Date getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//	public Date getLastAddressUpdate() {
//		return lastAddressUpdate;
//	}
//	public void setLastAddressUpdate(Date lastAddressUpdate) {
//		this.lastAddressUpdate = lastAddressUpdate;
//	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	
}
