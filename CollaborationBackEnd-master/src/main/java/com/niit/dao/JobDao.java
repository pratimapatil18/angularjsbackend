package com.niit.dao;

import java.util.List;

import com.niit.models.Job;

public interface JobDao {
	
	boolean saveJob(Job job);

	List<Job> getAllJob();

	Job getJobById(String id);
	
	 boolean updateJob(Job job);
	
	 boolean deleteJob(Job job);

}
