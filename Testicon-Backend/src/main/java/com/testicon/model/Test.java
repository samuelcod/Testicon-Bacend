package com.testicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the TESTS database table.
 * 
 */
@Entity
@Table(name="TESTS")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEST_ID")
	private long testId;

	@Lob
	private String about;

	private BigDecimal active;

	private BigDecimal duration;

	@Column(name="GRACE_PERIOD")
	private BigDecimal gracePeriod;

	private String name;

	@Column(name="PASSING_RESULT")
	private BigDecimal passingResult;

	private BigDecimal price;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="test", fetch = FetchType.EAGER)
	private List<Booking> bookings;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="COUNTRY", referencedColumnName="COUNTRY"),
		@JoinColumn(name="ORG_NBR", referencedColumnName="ORG_NBR")
		})
	@JsonIgnore
	private Provider provider;

	//bi-directional many-to-one association to TestResult
	@OneToMany(mappedBy="test")
	@JsonIgnore
	private List<TestResult> testResults;

	public Test() {
	}

	public long getTestId() {
		return this.testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public BigDecimal getActive() {
		return this.active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public BigDecimal getDuration() {
		return this.duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public BigDecimal getGracePeriod() {
		return this.gracePeriod;
	}

	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPassingResult() {
		return this.passingResult;
	}

	public void setPassingResult(BigDecimal passingResult) {
		this.passingResult = passingResult;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setTest(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setTest(null);

		return booking;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@JsonIgnore
	public List<TestResult> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public TestResult addTestResult(TestResult testResult) {
		getTestResults().add(testResult);
		testResult.setTest(this);

		return testResult;
	}

	public TestResult removeTestResult(TestResult testResult) {
		getTestResults().remove(testResult);
		testResult.setTest(null);

		return testResult;
	}
}