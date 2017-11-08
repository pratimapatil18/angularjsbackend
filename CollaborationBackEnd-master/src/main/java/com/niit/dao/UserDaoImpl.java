package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	private static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Override
	public boolean saveUser(User user) {
		try
		{
				Session session =sessionFactory.openSession();
				int newidno =session.createQuery("from User").list().size()+1;
				String id ="U"+newidno;
				user.setId(id);
				user.setUserrole("USER");
				session.save(user);
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
	public List<User> getAllUser() {
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> userList=query.list();
		session.close();
		return userList;
	}


	@Override
	public User getUserById(String id) {
		
		log.debug("->->Starting of the method getUser");
		String hql = "from User where id="+"'"+id+"'";
		
		log.debug("Query is : "+hql);
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (!list.isEmpty()) {
			User u=(User) list.get(0);
			log.debug("Got:"+u.getName());
			System.out.println(u.getName());
			System.out.println(u);
			return u;
		}
		
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(user);
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
	public boolean deleteUser(User user) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(user);
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
	public User isValidate(String email, String password) {
		
		log.debug("->->Starting of the method isValidUserDetails");
		String hql = "from User where email= '" + email + "' and " + " password ='" + password+"'";
		
		log.debug("Query is : "+hql);
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			User u=(User) list.get(0);
			log.debug("Got:"+u.getName());
		
			return u;
		}
		
		return null;
	}

	@Override
	public void setOnline(String userID) {
		
		log.debug("Starting of the method setOnline");
		String hql =" UPDATE User	SET isOnline = 'Y' where id='" +  userID + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
	
		log.debug("Ending of the metnod setOnline");
		
	}

	@Override
	public void updateProfilepic(String imagepath, String id) {
		log.debug("Starting of the method ");
		String hql =" UPDATE User	SET imagepath='" + imagepath + "' where id='" +  id + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		
	}

	@Override
	public User get(String id) {
		User userdetails= (User)sessionFactory.openSession().get(User.class, id);
		return userdetails;
	}

	@Override
	public List<User> searchlist(String name) {
		return sessionFactory.openSession().createQuery("from User where lower(name) like "+"'"+name.toLowerCase()+"'").list();
	}

	@Override
	public User getUserByName(String nm) {
String hql = "from User where name= '" + nm+"'";
		
		
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			User u=(User) list.get(0);
			log.debug("Got:"+u.getName());
		
			return u;
		}
		
		return null;
		
	}	
}
