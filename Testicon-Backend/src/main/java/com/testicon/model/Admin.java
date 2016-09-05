package com.testicon.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ADMINS database table.
 * 
 */
@Entity
@Table(name="ADMINS")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADMIN_ID")
	private long adminId;

	private String company;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="SUPER_ADMIN")
	private BigDecimal superAdmin;

	@Column(name="TELE_NBR")
	private String teleNbr;

	@Column(name="TEMP_EMAIL")
	private String tempEmail;

	@Column(name="TEMP_PASSWORD")
	private String tempPassword;

	//bi-directional many-to-many association to TestCenter
//	@ManyToMany(mappedBy="admins")
//	private List<TestCenter> testCenters;

	public Admin() {
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSuperAdmin() {
		return this.superAdmin;
	}

	public void setSuperAdmin(BigDecimal superAdmin) {
		this.superAdmin = superAdmin;
	}

	public String getTeleNbr() {
		return this.teleNbr;
	}

	public void setTeleNbr(String teleNbr) {
		this.teleNbr = teleNbr;
	}

	public String getTempEmail() {
		return this.tempEmail;
	}

	public void setTempEmail(String tempEmail) {
		this.tempEmail = tempEmail;
	}

	public String getTempPassword() {
		return this.tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	/*public List<TestCenter> getTestCenters() {
		return this.testCenters;
	}

	public void setTestCenters(List<TestCenter> testCenters) {
		this.testCenters = testCenters;
	}*/

}