package com.william.to;

import java.util.regex.Pattern;

import com.william.util.FieldPassFilterUtil;

public class RegisterInDTO {
	private String email;
	private String password;
	private String nickname;
	private String country;
	private String province;
	private String city;
	private String googleCountry;
	private String googleProvince;
	private String googleCity;
	private String longitude;
	private String latitude;
	
	public RegisterInDTO(){
		
	}
	

	public RegisterInDTO(String email, String password, String nickname, String country, String province, String city,
			String googleCountry, String googleProvince, String googleCity, String longitude, String latitude) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.country = country;
		this.province = province;
		this.city = city;
		this.googleCountry = googleCountry;
		this.googleProvince = googleProvince;
		this.googleCity = googleCity;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public ValidationResult isValid(){
		ValidationResult validationResult = new ValidationResult();
		StringBuilder sb = new StringBuilder();
		boolean inputValid = true;
		
		
		if(!FieldPassFilterUtil.validEmailAdreess(email)){
			inputValid = false;
			sb.append("\n email is not valid!");
		}
		
		if(!FieldPassFilterUtil.validPasswordLength(password)){
			inputValid = false;
			sb.append("\n password is not valid!");
		}
		
		if(!FieldPassFilterUtil.validAlphOnly(city)){
			inputValid = false;
			sb.append("\n city is not valid!");
		}
		
		if(!FieldPassFilterUtil.validAlphOnly(country)){
			inputValid = false;
			sb.append("\n country is not valid!");
		}
		
		if(!FieldPassFilterUtil.validAlphOnly(province)){
			inputValid = false;
			sb.append("\n province is not valid!");
		}
		
    	
    	validationResult.setResultString(sb.toString());
    	validationResult.setResultValid(inputValid);
		return validationResult;
	}
}
