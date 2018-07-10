package com.ipd12.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

//@Entity
//@Table(name="student2") //create student2 table as same as student, un-comment this annotation
public class Student3 {

	@Id
	private String studentID;
	
	//@Column(name="user")
	private String username;
	
	private String password;
	private String city;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Student [username=" + username + ", password=" + password + ", city=" + city + "]";
	}

	private Set emailAddresses = new HashSet();
	 public Set getEmailAddresses() {
	 return emailAddresses;
	 }
	 public void setEmailAddresses(Set emailAddresses) {
	 this.emailAddresses = emailAddresses;
	 }
}
