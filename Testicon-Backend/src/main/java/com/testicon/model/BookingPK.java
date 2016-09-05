package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BOOKINGS database table.
 * 
 */
//@Embeddable
public class BookingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	@Column(name="TEST_ID", insertable=false, updatable=false)
	private long testId;

	@Temporal(TemporalType.DATE)
	@Column(name="BOOKING_TIME")
	private java.util.Date bookingTime;

	public BookingPK() {
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTestId() {
		return this.testId;
	}
	public void setTestId(long testId) {
		this.testId = testId;
	}
	public java.util.Date getBookingTime() {
		return this.bookingTime;
	}
	public void setBookingTime(java.util.Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookingPK)) {
			return false;
		}
		BookingPK castOther = (BookingPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.testId == castOther.testId)
			&& this.bookingTime.equals(castOther.bookingTime);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		hash = hash * prime + ((int) (this.testId ^ (this.testId >>> 32)));
		hash = hash * prime + this.bookingTime.hashCode();
		
		return hash;
	}
}