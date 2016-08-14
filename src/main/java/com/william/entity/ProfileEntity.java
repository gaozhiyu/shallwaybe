package com.william.entity;

import java.util.Date;

public class ProfileEntity implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userIntID;
	private String email;
	private String password;
	private String nickname;
	private String gender;
	private Date dateOfBirth;
	private Date profilePhoto;
	private int wrongTryPWD;
	private String OTP;
	private Date OTPExpiryTime;
	private int wrongTryOTP;
	private String country;
	private String province;
	private String city;
	private String googleCountry;
	private String googleProvince;
	private String googleCity;
	private double longitude;
	private double latitude;
	private Date lastUpdate; 
	private Date createTime;   
	private Date lastAddressUpdate;  	
	private String signature; //ge xing qian ming
	
	public ProfileEntity(){
		super();
	}


	public ProfileEntity(String userIntID, String email, String password, String nickname, String gender,
			Date dateOfBirth, Date profilePhoto, int wrongTryPWD, String oTP, Date oTPExpiryTime,
			int wrongTryOTP, String country, String province, String city, String googleCountry,
			String googleProvince, String googleCity, double longitude, double latitude, Date lastUpdate,
			Date createTime, Date lastAddressUpdate, String signature) {
		super();
		this.userIntID = userIntID;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.profilePhoto = profilePhoto;
		this.wrongTryPWD = wrongTryPWD;
		this.OTP = oTP;
		this.OTPExpiryTime = oTPExpiryTime;
		this.wrongTryOTP = wrongTryOTP;
		this.country = country;
		this.province = province;
		this.city = city;
		this.googleCountry = googleCountry;
		this.googleProvince = googleProvince;
		this.googleCity = googleCity;
		this.longitude = longitude;
		this.latitude = latitude;
		this.lastUpdate = lastUpdate;
		this.createTime = createTime;
		this.lastAddressUpdate = lastAddressUpdate;
		this.signature = signature;
	}


	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
//	public boolean isProfilePhoto() {
//		return profilePhoto;
//	}
//
//
//	public void setProfilePhoto(boolean profilePhoto) {
//		this.profilePhoto = profilePhoto;
//	}


	public Date getProfilePhoto() {
		return profilePhoto;
	}


	public void setProfilePhoto(Date profilePhoto) {
		this.profilePhoto = profilePhoto;
	}


	public int getWrongTryPWD() {
		return wrongTryPWD;
	}

	public void setWrongTryPWD(int wrongTryPWD) {
		this.wrongTryPWD = wrongTryPWD;
	}


	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public Date getOTPExpiryTime() {
		return OTPExpiryTime;
	}

	public void setOTPExpiryTime(Date oTPExpiryTime) {
		OTPExpiryTime = oTPExpiryTime;
	}

	public int getWrongTryOTP() {
		return wrongTryOTP;
	}

	public void setWrongTryOTP(int wrongTryOTP) {
		this.wrongTryOTP = wrongTryOTP;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public void setGoogleCountry(String gCountry) {
		this.googleCountry = gCountry;
	}

	public String getGoogleProvince() {
		return googleProvince;
	}

	public void setGoogleProvince(String gProvince) {
		this.googleProvince = gProvince;
	}

	public String getGoogleCity() {
		return googleCity;
	}

	public void setGoogleCity(String gCity) {
		this.googleCity = gCity;
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
