package com.william.to;

import java.util.Date;

public class ShallWayOutDTO {

	private String nickname;
	private String dateID;
	private String userIntID;
	private String country;
	private String province;
	private String city;
	private String place;
	private Date startTime; 
	private Date endTime;   
	private Date postTime;   
	
	private Boolean carPool;
	private Boolean freeTour;
	private Boolean hotelShare;
	private Boolean freeGuide;
	
	private String title;
	private String contact;
	private String description;
		
	public ShallWayOutDTO() {
		super();
	}

	public ShallWayOutDTO(String nickname, String dateID, String userIntID, String country, String province,
			String city, String place, Date startTime, Date endTime, Date postTime, Boolean carPool, Boolean freeTour,
			Boolean hotelShare, Boolean freeGuide, String title, String contact, String description) {
		super();
		this.nickname = nickname;
		this.dateID = dateID;
		this.userIntID = userIntID;
		this.country = country;
		this.province = province;
		this.city = city;
		this.place = place;
		this.startTime = startTime;
		this.endTime = endTime;
		this.postTime = postTime;
		this.carPool = carPool;
		this.freeTour = freeTour;
		this.hotelShare = hotelShare;
		this.freeGuide = freeGuide;
		this.title = title;
		this.contact = contact;
		this.description = description;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDateID() {
		return dateID;
	}

	public void setDateID(String dateID) {
		this.dateID = dateID;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Boolean getCarPool() {
		return carPool;
	}

	public void setCarPool(Boolean carPool) {
		this.carPool = carPool;
	}

	public Boolean getFreeTour() {
		return freeTour;
	}

	public void setFreeTour(Boolean freeTour) {
		this.freeTour = freeTour;
	}

	public Boolean getHotelShare() {
		return hotelShare;
	}

	public void setHotelShare(Boolean hotelShare) {
		this.hotelShare = hotelShare;
	}

	public Boolean getFreeGuide() {
		return freeGuide;
	}

	public void setFreeGuide(Boolean freeGuide) {
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
