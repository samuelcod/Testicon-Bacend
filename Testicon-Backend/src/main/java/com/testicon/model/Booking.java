package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the BOOKINGS database table.
 * 
 */
@Entity
@Table(name="BOOKINGS")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_TIME")
	private Date endTime;

	private BigDecimal paid;

	@Column(name="PAYP_REF")
	private String paypRef;

	@Column(name="SEAT_NUMBER")
	private BigDecimal seatNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="START_TIME")
	private Date startTime;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="COUNTRY", referencedColumnName="COUNTRY"),
		@JoinColumn(name="ORG_NBR", referencedColumnName="ORG_NBR")
		})
	//@JsonIgnore
	private Provider provider;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="TEST_ID",insertable=false, updatable=false)
	private Test test;

	//bi-directional many-to-one association to TestCenter
	@ManyToOne
	@JoinColumn(name="TEST_CENTER_ID")
	private TestCenter testCenter;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID",insertable=false, updatable=false)
	@JsonIgnore
	private User user;

	public Booking() {
	}

	public BookingPK getId() {
		return this.id;
	}

	public void setId(BookingPK id) {
		this.id = id;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getPaid() {
		return this.paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public String getPaypRef() {
		return this.paypRef;
	}

	public void setPaypRef(String paypRef) {
		this.paypRef = paypRef;
	}

	public BigDecimal getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(BigDecimal seatNumber) {
		this.seatNumber = seatNumber;
	}


	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TestCenter getTestCenter() {
		return this.testCenter;
	}

	public void setTestCenter(TestCenter testCenter) {
		this.testCenter = testCenter;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}