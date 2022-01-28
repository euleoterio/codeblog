package com.spring.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog.model.CreatePost;

public interface CodeBlogRepository extends JpaRepository<CreatePost, Long> {

}
