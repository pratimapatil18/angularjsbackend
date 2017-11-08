package com.niit.CollaborationBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobApplicationDao;
import com.niit.models.JobApplication;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class JobApplicationDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static JobApplication jobApplication;
	
	@Autowired
	private static JobApplicationDao jobApplicationDao;
	
	@BeforeClass
	public static void init()
	{
	    context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.niit");
		context.refresh();
		
		jobApplication= (JobApplication) context.getBean("jobApplication");
		jobApplicationDao= (JobApplicationDao) context.getBean("jobApplicationDao");
		
	}

	@Test
	public void createJobApplicationTestCase()
	{
		
		jobApplication.setJobid("F007");
		jobApplication.setUserid("U008");
		
		jobApplication.setStatus("N");
		
		boolean flag=jobApplicationDao.save(jobApplication);
		assertEquals("createJobApplicationTestCase",true,flag);
	}
	
	@Test
	public void updateJobApplicationTestCase()
	{
		jobApplication.setJobid("F007");
		jobApplication.setUserid("U008");
	
		jobApplication.setStatus("N");
		
		boolean flag=jobApplicationDao.updateJobApplication(jobApplication);
		assertEquals("updateJobApplicationTestCase",true,flag);
		
	}
	
	
	@Test
    public void deleteJobApplication()
    {
		jobApplication.setJobid("SK6547");
 	   
 	   boolean flag = jobApplicationDao.deleteJobApplication(jobApplication);
 	   
 	   Assert.assertEquals( "deleteJobApplicationTestCase" ,true, flag);   
 	   
    }
 
	
	@Test
	public void getFriendTestCase()
	{
		jobApplication= jobApplicationDao.get("F006");
		assertEquals("getJobApplicationTestCase", null,jobApplication);
	}
	
	
}
