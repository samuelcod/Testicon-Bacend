package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TEST_RESULTS database table.
 * 
 */
@Embeddable
public class TestResultPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	@Column(name="TEST_ID", insertable=false, updatable=false)
	private long testId;

	@Temporal(TemporalType.DATE)
	@Column(name="TEST_DATE")
	private java.util.Date testDate;

	public TestResultPK() {
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
	public java.util.Date getTestDate() {
		return this.testDate;
	}
	public void setTestDate(java.util.Date testDate) {
		this.testDate = testDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TestResultPK)) {
			return false;
		}
		TestResultPK castOther = (TestResultPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.testId == castOther.testId)
			&& this.testDate.equals(castOther.testDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		hash = hash * prime + ((int) (this.testId ^ (this.testId >>> 32)));
		hash = hash * prime + this.testDate.hashCode();
		
		return hash;
	}
}