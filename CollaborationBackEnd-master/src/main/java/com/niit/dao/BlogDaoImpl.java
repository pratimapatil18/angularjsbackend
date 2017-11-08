package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Blog;

@Repository
public class BlogDaoImpl implements BlogDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(BlogDaoImpl.class);
	
	@Override
	public boolean saveBlog(Blog blog) {
		try
		{
				Session session =sessionFactory.openSession();
				int newidno =session.createQuery("from Blog").list().size()+1;
				String id ="B"+newidno;
				blog.setId(id);
				session.save(blog);
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
	public List<Blog> getAllBlog() {
		
		return sessionFactory.openSession().createQuery("from Blog").list();
		
	
	}


	@Override
	public boolean updateBlog(Blog blog) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(blog);
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
	public boolean deleteBlog(Blog blog) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(blog);
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
	public Blog get(String id) {
		log.debug("Starting get method");
		Blog blog=	(Blog) sessionFactory.openSession().get(Blog.class, id);
		log.debug("Ending get method"+blog);
			return blog;
	}
}
