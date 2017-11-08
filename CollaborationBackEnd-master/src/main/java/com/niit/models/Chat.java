package com.niit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Chat extends BaseDomain {
	
	@Id
	@Column(name="CHATID")
	private String id;
	
	@Column(name="USERID")
	private String userid;
	
	@Column(name="FRIENDID")
	private String friendid;
	
	@Column(name="date_time")
	private Date dateTime;
	
	@Column
	private String message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String user_id) {
		this.userid = userid;
	}
	public String getFriendid() {
		return friendid;
	}
	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = new Date();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
