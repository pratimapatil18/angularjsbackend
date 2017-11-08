package com.niit.dao;

import java.util.List;

import com.niit.models.Blog;

public interface BlogDao {

	boolean saveBlog(Blog blog);

	List<Blog> getAllBlog();

	 boolean updateBlog(Blog blog);
	
	 boolean deleteBlog(Blog blog);

	Blog get(String id);

}
