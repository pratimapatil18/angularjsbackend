package com.niit.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.BlogComment;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao{
	
	@Autowired
	SessionFactory sessionFactory;


	
	public boolean saveBlogComment(BlogComment blogcomment) {
		
		try
		{
				Session session =sessionFactory.openSession();
				String newidno =UUID.randomUUID().toString().substring(24).toUpperCase();
				String id =("Bcmnt"+newidno).substring(0, 9);
				blogcomment.setId(id);
				System.out.println();
				session.save(blogcomment);
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

	
	public List<BlogComment> getAllBlogComment(String blogid) {
		
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery(" from BlogComment where blogid='"+blogid+"'");
		List<BlogComment> blogcommentList=query.list();
		session.close();
		return blogcommentList;
	}

	public BlogComment getBlogCommentById(String id) {
		
		Session session=sessionFactory.openSession();
		BlogComment blogcomment=(BlogComment)session.get(BlogComment.class, id);
        session.close();
        return blogcomment;
	}
	
	public boolean updateBlogComment(BlogComment blogcomment) {
		

		try {
				Session session =sessionFactory.openSession();
				session.update(blogcomment);
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

	
	public boolean deleteBlogComment(BlogComment blogcomment) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(blogcomment);
			session.flush();
			session.close();
			return true;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

}
