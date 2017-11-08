package com.niit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="JOBAPPLN")
public class JobApplication extends BaseDomain {
	
	@Id
	@Column(name="JOBAPPLN_ID")
	private String id;
	
	@Column(name="JOB_ID")
	private String jobid;
	
	@Column(name="USER_ID")
	private String userid;
	
	@Column(name="APPLIED_DATA")
	private Date applieddate;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="REASON")
	private String reason;
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
