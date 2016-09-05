package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	private String address;

	private String city;

	private String company;

	private BigDecimal confirmed;

	private String country;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;
	@JsonIgnore
	private String password;

	@Column(name="PERS_NBR")
	private String persNbr;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="TELE_NBR")
	private String teleNbr;
	@JsonIgnore
	@Column(name="TEMP_EMAIL")
	private String tempEmail;
	@JsonIgnore
	@Column(name="TEMP_PASSWORD")
	private String tempPassword;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="user" , fetch = FetchType.EAGER)
	private List<Booking> bookings;

	/*provider test person key */
	//bi-directional many-to-one association to Ptpk
	@JsonIgnore
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<Ptpk> ptpks;

	//bi-directional many-to-one association to TestResult
	@JsonIgnore
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<TestResult> testResults;

	public User() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public BigDecimal getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(BigDecimal confirmed) {
		this.confirmed = confirmed;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersNbr() {
		return this.persNbr;
	}

	public void setPersNbr(String persNbr) {
		this.persNbr = persNbr;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getTeleNbr() {
		return this.teleNbr;
	}

	public void setTeleNbr(String teleNbr) {
		this.teleNbr = teleNbr;
	}

	public String getTempEmail() {
		return this.tempEmail;
	}

	public void setTempEmail(String tempEmail) {
		this.tempEmail = tempEmail;
	}

	public String getTempPassword() {
		return this.tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setUser(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setUser(null);

		return booking;
	}

	public List<Ptpk> getPtpks() {
		return this.ptpks;
	}

	public void setPtpks(List<Ptpk> ptpks) {
		this.ptpks = ptpks;
	}

	public Ptpk addPtpk(Ptpk ptpk) {
		getPtpks().add(ptpk);
		ptpk.setUser(this);

		return ptpk;
	}

	public Ptpk removePtpk(Ptpk ptpk) {
		getPtpks().remove(ptpk);
		ptpk.setUser(null);

		return ptpk;
	}

	public List<TestResult> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public TestResult addTestResult(TestResult testResult) {
		getTestResults().add(testResult);
		testResult.setUser(this);

		return testResult;
	}

	public TestResult removeTestResult(TestResult testResult) {
		getTestResults().remove(testResult);
		testResult.setUser(null);

		return testResult;
	}

}