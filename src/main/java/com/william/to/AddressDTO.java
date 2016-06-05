package com.william.to;

public class AddressDTO {


	
	String city;
	String province;
	String country;
	String county;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	@Override
	public String toString() {
		return "AddressDTO [city=" + city + ", state=" + province + ", country="
				+ country + ", county=" + county + "]";
	}
	
	
	
}
