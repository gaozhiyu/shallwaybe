// added on 31.1.2016 by Huzong for testing of DB access
package com.william.entity;

public class Person implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer personID;
	private String lastName;
	private String firstName;
	private String gender;

	public Person() {
	}

	public Person(String lastName, String firstName, String gender) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	} 

	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}