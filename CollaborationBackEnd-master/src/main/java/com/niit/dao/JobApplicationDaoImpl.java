package com.niit.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.JobApplication;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(JobApplication jobApplication) {
		
		try
		{
				Session session =sessionFactory.openSession();
				int newidno =session.createQuery("from JobApplication").list().size()+1;
				String id ="JA"+newidno;
				jobApplication.setApplieddate(new java.util.Date());
				jobApplication.setId(id);
				session.save(jobApplication);
				session.flush();
				session.close();
		return true;
		} 
		catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	@Override
	public List<JobApplication> getAlljobapplication(String userid) {
		
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from JobApplication where userid='"+ userid +"'");
		List<JobApplication> jobApplicationList=query.list();
		session.close();
		return jobApplicationList;
	}

	@Override
	public JobApplication get(String id) {
		
		Session session=sessionFactory.openSession();
		JobApplication jobApplication=(JobApplication)session.get(JobApplication.class, id);
        session.close();
        return jobApplication;
	}

	@Override
	public boolean updateJobApplication(JobApplication jobApplication) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(jobApplication);
			session.flush();
			session.close();
			return true;
		}
	catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJobApplication(JobApplication jobApplication) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(jobApplication);
			session.flush();
			session.close();
			return true;
		}
	catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<JobApplication> list() {
		return sessionFactory.openSession().createQuery("from JobApplication").list();
	}
	
	

}
