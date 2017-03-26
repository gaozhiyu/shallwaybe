package com.william.to;

import java.util.Date;

import com.william.vo.CommonVO;

public class ProfileOutDTO extends CommonVO{

	private String nickname;
	private String country;
	private String province;
	private String city;
	private String gender;
	private Date profilePhoto;
	private String dateOfBirth;
	private String visitedCities;
	private String registerCities;
	private String signature;
	private AddressHistoryOutDTO[] visitedArray;
	private AddressHistoryOutDTO[] registedArray;
	
	
	
	
	
	
	public AddressHistoryOutDTO[] getVisitedArray() {
		return visitedArray;
	}
	public void setVisitedArray(AddressHistoryOutDTO[] visitedArray) {
		this.visitedArray = visitedArray;
	}
	public AddressHistoryOutDTO[] getRegistedArray() {
		return registedArray;
	}
	public void setRegistedArray(AddressHistoryOutDTO[] registedArray) {
		this.registedArray = registedArray;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public Date getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(Date profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getVisitedCities() {
		return visitedCities;
	}
	public void setVisitedCities(String visitedCities) {
		this.visitedCities = visitedCities;
	}
	public String getRegisterCities() {
		return registerCities;
	}
	public void setRegisterCities(String registerCities) {
		this.registerCities = registerCities;
	} 
	
	
	
}
