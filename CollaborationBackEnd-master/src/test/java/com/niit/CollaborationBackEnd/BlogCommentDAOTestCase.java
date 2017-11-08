package com.niit.CollaborationBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogCommentDao;
import com.niit.models.BlogComment;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BlogCommentDAOTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static BlogComment blogComment;
	
	@Autowired
	private static BlogCommentDao blogCommentDao;
	
	@BeforeClass
	public static void init()
	{
	context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.niit");
		context.refresh();
		
		blogComment= ( BlogComment) context.getBean("blogComment");
		blogCommentDao= ( BlogCommentDao) context.getBean("friendDao");
		
	}

	@Test
	public void createBlogCommentTestCase()
	{
		
		blogComment.setBlogid("F007");
		blogComment.setUserid("U008");
		blogComment.setComment("HAHAHA");
		
		boolean flag=blogCommentDao.saveBlogComment(blogComment);
		assertEquals("createBlogCommentTestCase",true,flag);
	}
	
	@Test
	public void updateBlogCommentTestCase()
	{
		

		blogComment.setBlogid("XRC001");
		blogComment.setUserid("H002");
		blogComment.setComment("YES");
		
		
		boolean flag=blogCommentDao.updateBlogComment(blogComment);
		assertEquals("updateBlogCommentTestCase",true,flag);
		
	}
	
	
	@Test
    public void deleteBlogComment()
    {
		blogComment.setBlogid("F007");
 	   
 	   boolean flag = blogCommentDao.deleteBlogComment(blogComment);
 	   
 	   Assert.assertEquals( "deleteBlogCommentTestCase" ,true, flag);   
 	   
    }
 
	
	@Test
	public void getBlogCommentTestCase()
	{
		blogComment= blogCommentDao.getBlogCommentById("XRC00");
		assertEquals("getBlogCommentTestCase", null,blogComment);
	}
	
	@Test
	public void getAllBlogCommentTestCase()
	{
		int recordsFromDao =  blogCommentDao.getAllBlogComment(null).size();
	 	  
	 	  Assert.assertEquals("getAllBlogCommentTestCase" ,1 , recordsFromDao);
	}

}
