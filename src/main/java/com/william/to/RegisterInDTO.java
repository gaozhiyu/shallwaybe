package com.william.to;

public class RegisterInDTO {
	private String email;
	private String password;
	private String nickname;
	private String country;
	private String province;
	private String city;	
	
	public RegisterInDTO(){
		
	}

	public RegisterInDTO(String email, String password, String nickName, String country, String province, String city) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickName;
		this.country = country;
		this.province = province;
		this.city = city;
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

	public void setNickName(String nickname) {
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
}
