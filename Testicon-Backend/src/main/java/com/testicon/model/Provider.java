package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PROVIDERS database table.
 * 
 */
@Entity
@Table(name="PROVIDERS")
@NamedQuery(name="Provider.findAll", query="SELECT p FROM Provider p")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProviderPK id;
	@JsonIgnore
	private BigDecimal active;

	private String company;

	private String email;

	@Column(name="FAIL_GRACE_PERIOD")
	private BigDecimal failGracePeriod;

	@Column(name="GRACE_PERIOD")
	private BigDecimal gracePeriod;

	@Column(name="TELE_NBR")
	private String teleNbr;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="provider" ,fetch = FetchType.EAGER)
	
	
	@JsonIgnore
	private List<Booking> bookings;

	//bi-directional many-to-one association to Ptpk
	@OneToMany(mappedBy="provider",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Ptpk> ptpks;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="provider",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Test> tests;

	//bi-directional many-to-one association to TestResult
	@OneToMany(mappedBy="provider",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<TestResult> testResults;

	public Provider() {
	}

	public ProviderPK getId() {
		return this.id;
	}

	public void setId(ProviderPK id) {
		this.id = id;
	}

	public BigDecimal getActive() {
		return this.active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getFailGracePeriod() {
		return this.failGracePeriod;
	}

	public void setFailGracePeriod(BigDecimal failGracePeriod) {
		this.failGracePeriod = failGracePeriod;
	}

	public BigDecimal getGracePeriod() {
		return this.gracePeriod;
	}

	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
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
		booking.setProvider(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setProvider(null);

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
		ptpk.setProvider(this);

		return ptpk;
	}

	public Ptpk removePtpk(Ptpk ptpk) {
		getPtpks().remove(ptpk);
		ptpk.setProvider(null);

		return ptpk;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setProvider(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setProvider(null);

		return test;
	}

	public List<TestResult> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public TestResult addTestResult(TestResult testResult) {
		getTestResults().add(testResult);
		testResult.setProvider(this);

		return testResult;
	}

	public TestResult removeTestResult(TestResult testResult) {
		getTestResults().remove(testResult);
		testResult.setProvider(null);

		return testResult;
	}

}