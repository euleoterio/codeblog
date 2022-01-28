package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.CreatePost;

public interface CodeBlogService {
	
	List<CreatePost> findAll();
	CreatePost findById(long id);
	CreatePost save(CreatePost post);

}
