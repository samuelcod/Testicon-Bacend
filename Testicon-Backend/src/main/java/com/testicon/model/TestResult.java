package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TEST_RESULTS database table.
 * 
 */
@Entity
@Table(name="TEST_RESULTS")
@NamedQuery(name="TestResult.findAll", query="SELECT t FROM TestResult t")
public class TestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TestResultPK id;

	private BigDecimal passed;

	@Column(name="TEST_RESULT")
	private BigDecimal testResult;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="COUNTRY", referencedColumnName="COUNTRY"),
		@JoinColumn(name="ORG_NBR", referencedColumnName="ORG_NBR")
		})
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
	private User user;

	public TestResult() {
	}

	public TestResultPK getId() {
		return this.id;
	}

	public void setId(TestResultPK id) {
		this.id = id;
	}

	public BigDecimal getPassed() {
		return this.passed;
	}

	public void setPassed(BigDecimal passed) {
		this.passed = passed;
	}

	public BigDecimal getTestResult() {
		return this.testResult;
	}

	public void setTestResult(BigDecimal testResult) {
		this.testResult = testResult;
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