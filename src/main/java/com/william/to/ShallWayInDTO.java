package com.william.to;

import java.util.regex.Pattern;

public class ShallWayInDTO {

	private String userIntID;
//	private String nickName;
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
		


	public ShallWayInDTO(String userIntID, String country, String province, String city, String place,
			String startTime, String endTime, String carPool, String freeTour, String hotelShare, String freeGuide,
			String title, String contact, String description) {
		super();
		this.userIntID = userIntID;
//		this.nickName = nickName;
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

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

//	public String getNickName() {
//		return nickName;
//	}
//
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}

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
	
	public ValidationResult isValid(){
		ValidationResult shallWayInValidationResult = new ValidationResult();
		StringBuilder sb = new StringBuilder();
		boolean inputValid = true;
		
		String userIntIDString ="^[0-9a-zA-Z]+$";
    	boolean userIntIDMatch = Pattern.matches(userIntIDString, this.getUserIntID());
    	if (userIntIDMatch == false){
    		sb.append("\nUserIntID is not valid!");
    		inputValid =false;
    	}
    	
    	String countryString ="^[\u4e00-\u9fa5a-zA-Z]+$";
    	boolean countryMatch = Pattern.matches(countryString, this.getCountry());
    	if (countryMatch == false){
    		sb.append("\nCountry is not valid!");
    		inputValid =false;
    	}
    	
    	String provinceString ="^[\u4e00-\u9fa5a-zA-Z]+$";
    	boolean provinceMatch = Pattern.matches(provinceString, this.getProvince());
    	if (provinceMatch == false){
    		sb.append("\nProvince is not valid!");
    		inputValid =false;
    	}
    	
    	String cityString ="^[\u4e00-\u9fa5 a-zA-Z]+$";
    	boolean cityMatch = Pattern.matches(cityString, this.getCity());
    	if (cityMatch == false){
    		sb.append("\nCity is not valid!");
    		inputValid =false;
    	}
    	
    	String startTimeString ="^(\\d{1,2}/\\d{1,2}/\\d{4})$";
    	boolean startTimeMatch = Pattern.matches(startTimeString, this.getStartTime());
    	if (startTimeMatch == false){
    		sb.append("\nStartTime is not valid!");
    		inputValid =false;
    	}
    	
    	String endTimeString ="^(\\d{1,2}/\\d{1,2}/\\d{4})$";
    	boolean endTimeMatch = Pattern.matches(endTimeString, this.getEndTime());
    	if (endTimeMatch == false){
    		sb.append("\nEndTime is not valid!");
    		inputValid =false;
    	}
    	
    	String booleanString ="true|false";
    	boolean carPoolMatch = Pattern.matches(booleanString, this.getCarPool());
    	if (carPoolMatch == false){
    		sb.append("\nCarPool is not valid!");
    		inputValid =false;
    	}
    	
    	boolean freeTourMatch = Pattern.matches(booleanString, this.getFreeTour());
    	if (freeTourMatch == false){
    		sb.append("\nFreeTour is not valid!");
    		inputValid =false;
    	}
    	
    	boolean hotelShareMatch = Pattern.matches(booleanString, this.getHotelShare());
    	if (hotelShareMatch == false){
    		sb.append("\nHotelShare is not valid!");
    		inputValid =false;
    	}

    	boolean freeGuideMatch = Pattern.matches(booleanString, this.getFreeGuide());
    	if (freeGuideMatch == false){
    		sb.append("\nFreeGuide is not valid!");
    		inputValid =false;
    	}
    	
    	shallWayInValidationResult.setResultString(sb.toString());
    	shallWayInValidationResult.setResultValid(inputValid);
		return shallWayInValidationResult;
	}
}
