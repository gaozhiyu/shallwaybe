// Database trial by Huzong 20.2.2016
package com.william.entity;

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer employeeID;
	private String lastName;
	private String firstName;
	private Integer salary;

	public Employee() {
	}

	public Employee(String lastName, String firstName, Integer salary) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
}
