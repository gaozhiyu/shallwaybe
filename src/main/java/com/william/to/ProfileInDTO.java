package com.william.to;

import java.util.Date;

public class ProfileInDTO {

	private String shallWayID;
	private String email;
	private String password;
	private String nickName;
	private String gender;
	private String dateOfBirth;
	private String country;
	private String province;
	private String city;
//	private Date lastUpdate; 
//	private Date createTime;   
//	private Date lastAddressUpdate;  	
	private String status;
	
	public ProfileInDTO() {
		super();
	}

	public ProfileInDTO(String shallWayID, String email, String password, String nickName, String gender,
			String dateOfBirth, String country, String province, String city, String status) {
		super();
		this.shallWayID = shallWayID;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.province = province;
		this.city = city;
//		this.lastUpdate = lastUpdate;
//		this.createTime = createTime;
//		this.lastAddressUpdate = lastAddressUpdate;
		this.status = status;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 	
	
}
