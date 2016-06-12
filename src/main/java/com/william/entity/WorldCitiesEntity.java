package com.william.entity;

public class WorldCitiesEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String city;
	private String city_ASCII;
	private Double latitude;
	private Double longitude;
	private Double pop;
	private String country;
	private String iso2;
	private String iso3;
	private String province;
			
	public WorldCitiesEntity() {
		super();
	}


	
	public WorldCitiesEntity(String city, String city_ASCII, Double latitude, Double longitude, Double pop,
			String country, String iso2, String iso3, String province) {
		super();
		this.city = city;
		this.city_ASCII = city_ASCII;
		this.latitude = latitude;
		this.longitude = longitude;
		this.pop = pop;
		this.country = country;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.province = province;
	}



	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity_ASCII() {
		return city_ASCII;
	}
	public void setCity_ASCII(String city_ASCII) {
		this.city_ASCII = city_ASCII;
	}

	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Double getLongitude() {
		return longitude;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public Double getPop() {
		return pop;
	}
	public void setPop(Double pop) {
		this.pop = pop;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIso2() {
		return iso2;
	}
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
