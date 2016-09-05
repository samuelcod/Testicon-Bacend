package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PTPK database table.
 * 
 */
@Entity
@NamedQuery(name="Ptpk.findAll", query="SELECT p FROM Ptpk p")
public class Ptpk implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PtpkPK id;

	@Column(name="PTPK_ID")
	private String ptpkId;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="COUNTRY", insertable=false, updatable=false),
		@JoinColumn(name="ORG_NBR", insertable=false, updatable=false)
		})
	private Provider provider;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID", insertable=false, updatable=false)
	private User user;

	public Ptpk() {
	}

	public PtpkPK getId() {
		return this.id;
	}

	public void setId(PtpkPK id) {
		this.id = id;
	}

	public String getPtpkId() {
		return this.ptpkId;
	}

	public void setPtpkId(String ptpkId) {
		this.ptpkId = ptpkId;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}