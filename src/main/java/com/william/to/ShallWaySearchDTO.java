package com.william.to;

public class ShallWaySearchDTO {

	private String userIntID;
//	private String pageNumber;
	private String sequenceNo;
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
	
	public ShallWaySearchDTO() {
		super();
	}

	public ShallWaySearchDTO(String userIntID, String sequenceNo, String country, String province, String city,
			String place, String startTime, String endTime, String carPool, String freeTour, String hotelShare,
			String freeGuide) {
		super();
		this.userIntID = userIntID;
		this.sequenceNo =  sequenceNo;
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

	public String getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	
	
	
}
