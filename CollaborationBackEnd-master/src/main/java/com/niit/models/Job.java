package com.niit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="JOB")
public class Job extends BaseDomain {
	
	@Id
	@Column(name="JOB_ID")
	private String id;
	
	@Column(name="JOB_TITLE")
	private String jobtitle;
	
	@Column(name="JOB_DESCRIPTION")
	private String jobdescription;
	
	@Column(name="POSTDATE")
	private Date postdate;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
}
