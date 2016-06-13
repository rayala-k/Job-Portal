package com.neu.jobportal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name="personID", unique=true, nullable=false)
	private long personID;
	
	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName", nullable=false)
	private String lastName;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;	
	
	@Column(name="userName", unique=true, nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="mobileNumber")
	private String mobileNumber;
	
	@Transient
	private String confirmPassword;
	
	@Column(name="role", nullable=false)
	private String role;
	

	
	public Person(){
		
	}
	
	public Person(Person person){
		this.firstName =  person.getFirstName();
		this.lastName =  person.getLastName();
		this.middleName = person.getMiddleName();
		this.userName =  person.getUserName();
		this.password =  person.getPassword();
		this.email =  person.getEmail();
		this.role = person.getRole();
		this.mobileNumber = person.getMobileNumber();
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}

