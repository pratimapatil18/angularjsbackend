package com.niit.CollaborationBackEnd;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.models.Job;


@SuppressWarnings("deprecation")
public class JobDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static Job job;
	
	@Autowired
	private static JobDao jobDao;
	
	@BeforeClass
	public static void init()
	{
	    context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.niit");
		context.refresh();
		
		job= (Job) context.getBean("job");
		jobDao= (JobDao) context.getBean("jobDao");
		
	}

	@Test
	public void createJobTestCase()
	{
		
		job.setId("U008");
		job.setJobtitle("IT VACANCY");
		job.setJobdescription("IT JOB");
		
		boolean flag=jobDao.saveJob(job);
		assertEquals("createJobTestCase",true,flag);
	}
	
	@Test
	public void updateJobTestCase()
	{
		
		job.setId("zmv280");
		job.setJobtitle("CORE AUTOMATION");
		job.setJobdescription("ELECTRONIC CORE JOB");
		
		boolean flag=jobDao.updateJob(job);
		assertEquals("updateJobTestCase",true,flag);
	}
	
	
	@Test
    public void deleteJob()
    {
		job.setId("");
 	   
 	   boolean flag = jobDao.deleteJob(job);
 	   
 	   Assert.assertEquals( "deleteJobTestCase" ,true, flag);   
 	   
    }
 
	
	@Test
	public void getJobTestCase()
	{
		job= jobDao.getJobById("F006");
		assertEquals("getJobTestCase", null,job);
	}
	
	@Test
	public void getAllJobTestCase()
	{
		int recordsFromDao =  jobDao.getAllJob().size();
	 	  
	 	  Assert.assertEquals("getAllJobTestCase" ,1 , recordsFromDao);
	}
}
