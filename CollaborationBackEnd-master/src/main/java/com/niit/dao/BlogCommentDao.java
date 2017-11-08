package com.niit.dao;

import java.util.List;

import com.niit.models.BlogComment;

public interface BlogCommentDao {
	
	boolean saveBlogComment(BlogComment blogcomment);

	List<BlogComment> getAllBlogComment(String blogid);

	BlogComment getBlogCommentById(String id);
	
	 boolean updateBlogComment(BlogComment blogcomment);
	
	 boolean deleteBlogComment(BlogComment blogcomment);

}
