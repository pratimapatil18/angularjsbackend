package com.niit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BLOG_COMMENT")
public class BlogComment extends BaseDomain {
	
	@Id
	@Column(name="BLOGCOMMENT_ID")
	private String id;
	
	@Column(name="BLOG_ID")
	private String blogid;
	
	@Column(name="USER_ID")
	private String userid;
	
	@Column(name="COMMENTS")
	private String comment;
	
	@Column(name="DATE_ADDED")
	private Date date_added;
	

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}	

