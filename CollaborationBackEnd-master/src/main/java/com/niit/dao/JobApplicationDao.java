package com.niit.dao;

import java.util.List;

import com.niit.models.JobApplication;

public interface JobApplicationDao {

	
	 JobApplication get(String id);
	 
	 public List<JobApplication> list();
	
	 List<JobApplication> getAlljobapplication(String userid);

	 boolean save(JobApplication jobapplication);
	
	 boolean updateJobApplication(JobApplication jobapplication);
	
	 boolean deleteJobApplication(JobApplication jobapplication);
}
