package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Job;

@Repository
public class JobDaoImpl implements JobDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveJob(Job job) {
		try
		{
				Session session =sessionFactory.openSession();
				int newidno =session.createQuery("from Job").list().size()+1;
				String id ="SK"+newidno;
				job.setPostdate(new java.util.Date());
				job.setId(id);
				session.save(job);
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
	public List<Job> getAllJob() {
		
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobList=query.list();
		session.close();
		return jobList;
	}

	@Override
	public Job getJobById(String id) {
		
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, id);
        session.close();
        return job;
		
	}

	@Override
	public boolean updateJob(Job job) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(job);
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
	public boolean deleteJob(Job job) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(job);
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
}
