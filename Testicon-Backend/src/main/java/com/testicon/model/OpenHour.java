package com.testicon.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the OPEN_HOURS database table.
 * 
 */
@Entity
@Table(name="OPEN_HOURS")
@NamedQuery(name="OpenHour.findAll", query="SELECT o FROM OpenHour o")
public class OpenHour implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OpenHourPK id;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="MAX_SEATS")
	private BigDecimal maxSeats;

	@Column(name="START_TIME")
	private String startTime;

	//bi-directional many-to-one association to TestCenter
	@ManyToOne
	@JoinColumn(name="TEST_CENTER_ID",insertable=false, updatable=false)
	@JsonIgnore
	private TestCenter testCenter;

	public OpenHour() {
	}

	public OpenHourPK getId() {
		return this.id;
	}

	public void setId(OpenHourPK id) {
		this.id = id;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getMaxSeats() {
		return this.maxSeats;
	}

	public void setMaxSeats(BigDecimal maxSeats) {
		this.maxSeats = maxSeats;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public TestCenter getTestCenter() {
		return this.testCenter;
	}

	public void setTestCenter(TestCenter testCenter) {
		this.testCenter = testCenter;
	}

}