package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OPEN_HOURS database table.
 * 
 */
//@Embeddable
public class OpenHourPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TEST_CENTER_ID", insertable=false, updatable=false)
	private long testCenterId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DAY\"")
	private java.util.Date day;

	public OpenHourPK() {
	}
	public long getTestCenterId() {
		return this.testCenterId;
	}
	public void setTestCenterId(long testCenterId) {
		this.testCenterId = testCenterId;
	}
	public java.util.Date getDay() {
		return this.day;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OpenHourPK)) {
			return false;
		}
		OpenHourPK castOther = (OpenHourPK)other;
		return 
			(this.testCenterId == castOther.testCenterId)
			&& this.day.equals(castOther.day);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.testCenterId ^ (this.testCenterId >>> 32)));
		hash = hash * prime + this.day.hashCode();
		
		return hash;
	}
}