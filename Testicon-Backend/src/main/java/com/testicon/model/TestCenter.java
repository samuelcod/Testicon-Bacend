package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TEST_CENTERS database table.
 * 
 */
@Entity
@Table(name="TEST_CENTERS")
@NamedQuery(name="TestCenter.findAll", query="SELECT t FROM TestCenter t")
public class TestCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEST_CENTER_ID")
	private long testCenterId;

	private BigDecimal active;

	private String address;

	private String city;

	private String company;

	private String country;

	private String email;

	@Column(name="MAX_SEATS")
	private BigDecimal maxSeats;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="TELE_NBR")
	private String teleNbr;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="testCenter",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Booking> bookings;

	//bi-directional many-to-one association to OpenHour
	@OneToMany(mappedBy="testCenter",fetch = FetchType.EAGER)
	//@JsonIgnore
	private List<OpenHour> openHours;

	//bi-directional many-to-many association to Admin
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="TEST_CENTER_ADMINS"
		, joinColumns={
			@JoinColumn(name="TEST_CENTER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ADMIN_ID")
			}
		)
	//@JsonIgnore
	private List<Admin> admins;

	//bi-directional many-to-one association to TestResult
	@OneToMany(mappedBy="testCenter")
	@JsonIgnore
	private List<TestResult> testResults;

	public TestCenter() {
	}

	public long getTestCenterId() {
		return this.testCenterId;
	}

	public void setTestCenterId(long testCenterId) {
		this.testCenterId = testCenterId;
	}

	public BigDecimal getActive() {
		return this.active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
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

	public BigDecimal getMaxSeats() {
		return this.maxSeats;
	}

	public void setMaxSeats(BigDecimal maxSeats) {
		this.maxSeats = maxSeats;
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

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setTestCenter(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setTestCenter(null);

		return booking;
	}

	public List<OpenHour> getOpenHours() {
		return this.openHours;
	}

	public void setOpenHours(List<OpenHour> openHours) {
		this.openHours = openHours;
	}

	public OpenHour addOpenHour(OpenHour openHour) {
		getOpenHours().add(openHour);
		openHour.setTestCenter(this);

		return openHour;
	}

	public OpenHour removeOpenHour(OpenHour openHour) {
		getOpenHours().remove(openHour);
		openHour.setTestCenter(null);

		return openHour;
	}

	public List<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<TestResult> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public TestResult addTestResult(TestResult testResult) {
		getTestResults().add(testResult);
		testResult.setTestCenter(this);

		return testResult;
	}

	public TestResult removeTestResult(TestResult testResult) {
		getTestResults().remove(testResult);
		testResult.setTestCenter(null);

		return testResult;
	}

}