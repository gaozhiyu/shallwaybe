package com.william.entity;

import java.util.Date;

public class ShallWayEntity implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String shallWayID;
	private String country;
	private String city;
	private String place;
	private Date startTime; // check correct format to use 28.2.2016
	private Date endTime;   // check correct format to use 28.2.2016
	private Date postTime;   // check correct format to use 28.2.2016
	
	private Boolean carPool;
	private Boolean freeTour;
	private Boolean hotelShare;
	private Boolean freeGuide;
	
	private String title;
	private String contact;
	private String description;
		
	public ShallWayEntity() {
		super();
	}
	
	/* to create a record*/
	public ShallWayEntity(String id,String shallWayID, String country, String city, String place, Date startTime, Date endTime,
			Date postTime, Boolean carPool, Boolean freeTour, Boolean hotelShare, Boolean freeGuide, String title,
			String contact, String description) {
		super();
		this.id=id;
		this.shallWayID = shallWayID;
		this.country = country;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShallWayID() {
		return shallWayID;
	}
	public void setShallWayID(String shallWayID) {
		this.shallWayID = shallWayID;
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
