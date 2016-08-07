package com.william.vo;

import java.util.Date;

import com.william.to.GISDTO;

public class ProfileVO extends GISDTO {


	
	private String email;
	private String nickname;
	private String gender;
	private String dateOfBirth;
	private String country;
	private String province;
	private String city;	
	private String signature;
	private boolean addressFlag;
	private byte[] profilePIC;
	


	public byte[] getProfilePIC() {
		return profilePIC;
	}

	public void setProfilePIC(byte[] profilePIC) {
		this.profilePIC = profilePIC;
	}

	public boolean isAddressFlag() {
		return addressFlag;
	}

	public void setAddressFlag(boolean addressFlag) {
		this.addressFlag = addressFlag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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
	

	
}
