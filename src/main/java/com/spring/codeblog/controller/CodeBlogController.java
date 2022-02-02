package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.CreatePost;
import com.spring.codeblog.service.CodeBlogService;

@Controller
public class CodeBlogController {

	@Autowired
	CodeBlogService service;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<CreatePost> posts = service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		CreatePost post = service.findById(id);
		mv.addObject("post", post);
		return mv;
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String createPost(@Valid CreatePost post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("message", "Check that the mandatory fields have been filled!");
			return "redirect:/newPost";
		}

		post.setDate(LocalDate.now());
		service.save(post);

		return "redirect:/posts";
	}

}
