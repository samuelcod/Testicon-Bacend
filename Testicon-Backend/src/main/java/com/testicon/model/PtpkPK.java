package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PTPK database table.
 * 
 */
@Embeddable
public class PtpkPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	@Column(name="ORG_NBR", insertable=false, updatable=false)
	private String orgNbr;

	@Column(insertable=false, updatable=false)
	private String country;

	public PtpkPK() {
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOrgNbr() {
		return this.orgNbr;
	}
	public void setOrgNbr(String orgNbr) {
		this.orgNbr = orgNbr;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PtpkPK)) {
			return false;
		}
		PtpkPK castOther = (PtpkPK)other;
		return 
			(this.userId == castOther.userId)
			&& this.orgNbr.equals(castOther.orgNbr)
			&& this.country.equals(castOther.country);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		hash = hash * prime + this.orgNbr.hashCode();
		hash = hash * prime + this.country.hashCode();
		
		return hash;
	}
}