package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROVIDERS database table.
 * 
 */
@Embeddable
public class ProviderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORG_NBR")
	private String orgNbr;

	private String country;

	public ProviderPK() {
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
		if (!(other instanceof ProviderPK)) {
			return false;
		}
		ProviderPK castOther = (ProviderPK)other;
		return 
			this.orgNbr.equals(castOther.orgNbr)
			&& this.country.equals(castOther.country);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orgNbr.hashCode();
		hash = hash * prime + this.country.hashCode();
		
		return hash;
	}
}