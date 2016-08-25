package com.testicon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

 /*@Entity
 @Table(name="users")
 @NamedQueries({
	 @NamedQuery(name = "User.findByEmailAddress",
	 query = "select u from User u where u.email = ?1"),
	 @NamedQuery(name = "User.findByEmailAddress",
	 query = "select u from User u where u.lastName = ?1")
 })*/
public class User {
	
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String adress;
	private int postalCode;
	@NotNull
	private String city;
	private String state;
	@NotNull
	private String country;
	@NotNull
	private int personalNumber;
	@NotNull
	private String gender;
	private int telephoneNumber;
	private String company;
	@NotNull
	boolean myBoolean;
	private boolean confirmed;
	@NotNull
	private String password;
	private String tempPassword;
	private String tempEmail;
	
	
	public String getAdress() {
		return adress;
	}
	public String getCity() {
		return city;
	}
	public String getCompany() {
		return company;
	}
	public String getCountry() {
		return country;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getGender() {
		return gender;
	}
	public Long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public int getPersonalNumber() {
		return personalNumber;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public String getState() {
		return state;
	}
	public int getTelephoneNumber() {
		return telephoneNumber;
	}
	public String getTempEmail() {
		return tempEmail;
	}
	public String getTempPassword() {
		return tempPassword;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public void setTempEmail(String tempEmail) {
		this.tempEmail = tempEmail;
	}
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	
}
