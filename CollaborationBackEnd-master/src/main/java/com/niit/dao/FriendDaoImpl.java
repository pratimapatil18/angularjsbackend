package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Friend;

@Repository("friendDao")
public class FriendDaoImpl implements FriendDao{
	
	@Autowired
	SessionFactory sessionFactory;

	private static Logger log = LoggerFactory.getLogger(FriendDaoImpl.class);
	
	@Override
	public boolean deleteFriend(Friend friend) {
		
		try {
			Session session =sessionFactory.openSession();
			session.delete(friend);
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
	public boolean save(Friend friend) {
		try
		{
				Session session =sessionFactory.openSession();
				int newidno2 =session.createQuery("from Friend").list().size() +1;
				String id ="F"+newidno2;
				friend.setId(id);
				session.save(friend);
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
	public List<Friend> getAllFriends(String userID) {
		String hql = "from Friend where (userid=" + "'" + userID + "' and status='Y') or (friendid=" + "'" + userID + "' and status='Y')";
		log.debug("hql:" + hql);
		return (List<Friend>)sessionFactory.openSession().createQuery(hql).list();
	}

	@Override
	public Friend getFriendById(String id) {
		
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class, id);
        session.close();
        return friend;

	}

	@Override
	public boolean update(Friend friend) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(friend);
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
	public void setOnline(String userID) {
		
		log.debug("Starting of the metnod setOnline");
		//String hql = " UPDATE Friend	SET isOnline = 'Y' where friendID='" + friendID + "'";
		
		String hql = " UPDATE Friend	SET isOnline = 'Y' where friend_id= ?";
		
		log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		
		
		query.executeUpdate();
		log.debug("Ending of the metnod setOnline");

		
	}

	@Override
	public Friend get(String friendID, String userID) {
		String hql = "from Friend where userid=" + "'" + userID + "' and friendid= '" + friendID + "'";
		log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		log.debug(friendID);
		return (Friend) query.uniqueResult();
	}

	@Override
	public List<Friend> getAllRequests(String userID) {
		
		String hql="from Friend where friendid='"+userID+"'"+" and status='N'";
		return sessionFactory.openSession().createQuery(hql).list();
	}

	@Override
	public List<Friend> getSentRequests(String userID) {
		
		String hql="from Friend where user_id='"+userID+"'"+" and status='N'";
		return sessionFactory.openSession().createQuery(hql).list();
	}
}
