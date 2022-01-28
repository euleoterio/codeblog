package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.CreatePost;
import com.spring.codeblog.repository.CodeBlogRepository;

//Classe utilizada apenas para população inicial do banco

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository repository;

//    @PostConstruct
    public void saveCreatePosts(){

        List<CreatePost> CreatePostList = new ArrayList<>();
        CreatePost CreatePost1 = new CreatePost();
        CreatePost1.setAuthor("Bruno Alexandre");
        CreatePost1.setDate(LocalDate.now());
        CreatePost1.setTitle("Docker");
        CreatePost1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        CreatePost CreatePost2 = new CreatePost();
        CreatePost2.setAuthor("Michelli Brito");
        CreatePost2.setDate(LocalDate.now());
        CreatePost2.setTitle("API REST");
        CreatePost2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        CreatePostList.add(CreatePost1);
        CreatePostList.add(CreatePost2);

        for(CreatePost CreatePost: CreatePostList){
            CreatePost CreatePostSaved = repository.save(CreatePost);
            System.out.println(CreatePostSaved.getId());
        }
    }
}
