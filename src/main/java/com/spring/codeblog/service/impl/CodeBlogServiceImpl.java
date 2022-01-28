package com.spring.codeblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.CreatePost;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeBlogService;

@Service
public class CodeBlogServiceImpl implements CodeBlogService {

	@Autowired
	CodeBlogRepository repository;
	
	@Override
	public List<CreatePost> findAll() {
		return repository.findAll();
	}

	@Override
	public CreatePost findById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public CreatePost save(CreatePost post) {
		return repository.save(post);
	}

}
