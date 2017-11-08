package com.niit.dao;

import java.util.List;

import com.niit.models.Friend;

public interface FriendDao {
	
	boolean save(Friend friend);

	List<Friend> getAllFriends(String userID);
	
	Friend get(String friendID, String userID);

	Friend getFriendById(String id);
	
	boolean update(Friend friend);
	
	boolean deleteFriend(Friend friend);
	 
	public void setOnline(String userID);
	
	public List<Friend> getAllRequests(String userID);
	
	public List<Friend> getSentRequests(String userID);

}
