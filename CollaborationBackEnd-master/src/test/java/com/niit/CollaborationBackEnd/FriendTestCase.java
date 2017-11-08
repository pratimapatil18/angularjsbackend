package com.niit.CollaborationBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.FriendDao;
import com.niit.models.Friend;

import junit.framework.Assert;


public class FriendTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static Friend friend;
	
	@Autowired
	private static FriendDao friendDao;
	
	@BeforeClass
	public static void init()
	{
	context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.niit");
		context.refresh();
		
		friend= ( Friend) context.getBean("friend");
		friendDao= ( FriendDao) context.getBean("friendDao");
		
		System.out.println(friend);
		
		
	}
	
	//@Test
	public void createFriendTestCase()
	{
		
		friend.setUserid("U009");
		friend.setFriendid("F007");
		friend.setStatus("N");
		
		boolean flag=friendDao.save(friend);
		assertEquals("createFriendTestCase",true,flag);
	}
	


		@Test
	public void updateFriendTestCase()
	{
		
		friend.setUserid("U009");
		friend.setStatus("Y");
		friend.setFriendid("F007");
		
		boolean flag=friendDao.update(friend);
		assertEquals("updateFriendTestCase",true,flag);
		
	}
	
	
@Test
    public void deleteFriend()
    {
 	   friend.setFriendid("SK6547");
 	   
 	   boolean flag = friendDao.deleteFriend(friend);
 	   
 	   Assert.assertEquals( "deleteFriendTestCase" ,true, flag);   
 	   
    }
 
	
	@Test
	public void getFriendTestCase()
	{
		friend= friendDao.getFriendById("F007");
		assertEquals("getFriendTestCase", null,friend);
	}
	
	
}
