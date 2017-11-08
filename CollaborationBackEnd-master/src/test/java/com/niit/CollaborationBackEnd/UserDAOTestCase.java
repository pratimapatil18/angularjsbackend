package com.niit.CollaborationBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.models.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDao userDao;
	
	@BeforeClass
	public static void init()
	{
	    context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.niit");
		context.refresh();
		
		user= (User) context.getBean("user");
		System.out.println(user);
		userDao= ( UserDao) context.getBean("userDao");
		
	}

	@Test
	public void createUserTestCase()
	{
		user.setId("U008");
		
		user.setEmail("xyz@gmail.com");
		user.setUserrole("role");
		
		
		boolean flag=userDao.saveUser(user);
		assertEquals("createUserTestCase",true,flag);
	}
	
	@Test
	public void updateUserTestCase()
	{
		
		user.setId("U008");
		
		user.setEmail("xyz@gmail.com");
		user.setUserrole("role");
		
		
		boolean flag=userDao.updateUser(user);
		assertEquals("updateUserTestCase",true,flag);
		
	}
	
	@Test
    public void deleteUser()
    {
		user.setId("SK6547");
 	   
 	   boolean flag = userDao.deleteUser(user);
 	   
 	   Assert.assertEquals( "deleteUserTestCase" ,false, flag);   
    }
 
	
	@Test
	public void getUserTestCase()
	{
		user= userDao.getUserById("F006");
		assertEquals("getUserTestCase", null,user);
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int recordsFromDao =  userDao.getAllUser().size();	  
	 	  Assert.assertEquals("getAllUserTestCase" ,0 , recordsFromDao);
	}
}
