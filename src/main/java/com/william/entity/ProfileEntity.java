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
	private String country;
	private String province;
	private String city;
	private Date lastUpdate; 
	private Date createTime;   
	private Date lastAddressUpdate;  	
	private String signature; //ge xing qian ming
	
	public ProfileEntity(){
		super();
	}

	public ProfileEntity(String userIntID, String email, String password, String nickname, String gender, Date dateOfBirth,
			String country, String province,String city, Date lastUpdate, Date createTime, Date lastAddressUpdate, String signature) {
		super();
		this.userIntID = userIntID;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.province=province;
		this.city = city;
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
