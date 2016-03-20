package com.william.to;

import java.util.Date;

public class ProfileTo implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String shallWayID;
	private String email;
	private String password;
	private String nickName;
	private String gender;
	private Date dateOfBirth;
	private String country;
	private String city;
	private Date lastUpdate; 
	private Date createTime;   
	private Date lastAddressUpdate;  	
	private String status;
	
	public ProfileTo(){
		super();
	}

	public ProfileTo(String shallWayID, String email, String password, String nickName, String gender, Date dateOfBirth,
			String country, String city, Date lastUpdate, Date createTime, Date lastAddressUpdate, String status) {
		super();
		this.shallWayID = shallWayID;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.city = city;
		this.lastUpdate = lastUpdate;
		this.createTime = createTime;
		this.lastAddressUpdate = lastAddressUpdate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
