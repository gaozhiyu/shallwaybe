package com.william.to;

import java.util.Date;

public class ShallWayInDTO {

	private String shallWayID;
	private String nickName;
	private String country;
	private String province;
	private String city;
	private String place;
	private String startTime; 
	private String endTime;   
	
	private String carPool;
	private String freeTour;
	private String hotelShare;
	private String freeGuide;
	
	private String title;
	private String contact;
	private String description;
	
	
	
	public ShallWayInDTO() {
		super();
	}
		


	public ShallWayInDTO(String shallWayID, String nickName, String country, String province, String city, String place,
			String startTime, String endTime, String carPool, String freeTour, String hotelShare, String freeGuide,
			String title, String contact, String description) {
		super();
		this.shallWayID = shallWayID;
		this.nickName = nickName;
		this.country = country;
		this.province = province;
		this.city = city;
		this.place = place;
		this.startTime = startTime;
		this.endTime = endTime;
		this.carPool = carPool;
		this.freeTour = freeTour;
		this.hotelShare = hotelShare;
		this.freeGuide = freeGuide;
		this.title = title;
		this.contact = contact;
		this.description = description;
	}

	public String getShallWayID() {
		return shallWayID;
	}
	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCarPool() {
		return carPool;
	}
	public void setCarPool(String carPool) {
		this.carPool = carPool;
	}
	public String getFreeTour() {
		return freeTour;
	}
	public void setFreeTour(String freeTour) {
		this.freeTour = freeTour;
	}
	public String getHotelShare() {
		return hotelShare;
	}
	public void setHotelShare(String hotelShare) {
		this.hotelShare = hotelShare;
	}
	public String getFreeGuide() {
		return freeGuide;
	}
	public void setFreeGuide(String freeGuide) {
		this.freeGuide = freeGuide;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
