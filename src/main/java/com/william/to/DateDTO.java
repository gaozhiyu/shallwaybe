package com.william.to;

import com.william.vo.CommonInput;

//TODO refractor move to vo package

public class DateDTO extends CommonInput{
//	private String status;
	private String dateid;
	//private String userid;
	private String Starttime;
	private String endtime;
	private String title;
	private String place;
	private String country;
	private String province;
	private String city;
	private String sequenceID;



	public String getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getDateid() {
		return dateid;
	}
	public void setDateid(String dateid) {
		this.dateid = dateid;
	}


	public String getStarttime() {
		return Starttime;
	}
	public void setStarttime(String starttime) {
		Starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	
	


	
	

}
