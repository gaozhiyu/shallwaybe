package com.william.to;

import com.william.vo.CommonVO;

public class ProfileOutDTO extends CommonVO{

	private String nickname;
	private String country;
	private String province;
	private String city;
	private String gender;
	private byte[] profilePIC;
	private String dateOfBirth;
	private String visitedCities;
	private String registerCities;
	
	
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
	public byte[] getProfilePIC() {
		return profilePIC;
	}
	public void setProfilePIC(byte[] profilePIC) {
		this.profilePIC = profilePIC;
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
