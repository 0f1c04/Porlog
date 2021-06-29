package com.kosta.finalProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostService;
import com.kosta.finalProject.service.UserService;


@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	
	
	@GetMapping("/blogList")
	public String selectUsers(Model model, String userID, Principal principal) {
		System.out.println(principal.getName());
		model.addAttribute("bloglist", blogService.selectAll());
		model.addAttribute("user", userService.selectById(principal.getName()));
		return "blogList";
	}
	
	@PostMapping("/blogInsert")
	public String blogInsert(Model model, BlogDTO blog,String userID, RedirectAttributes rttr) {
		UserDTO user = userService.selectById(userID);
		blog.setUser(user);
		blogService.insertBlog(blog);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = postService.selectByBlog(blog);
		model.addAttribute("postlist",postlist);
		return "redirect:/basic";
	}
	
	@GetMapping("/blogInsert")
	public String blogInsert(Model model, String userID) {
		model.addAttribute("userID", userID);
		return "/blog/blogInsert";
	}

	@GetMapping("/basic")
	public String selectById(Model model, String userID, Principal principal) {
		UserDTO user = userService.selectById(userID);
		BlogDTO blog = blogService.selectByUser(user);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = postService.selectByBlog(blog);
		model.addAttribute("postlist", postlist);
		model.addAttribute("user", userService.selectById(principal.getName()));
		System.out.println(userID);
		return "/basic"; 
	}
	
	@PostMapping("/blogUpdate")
	public String blogUpdate(Model model, String blogTitle, UserDTO user, RedirectAttributes rttr) {
		BlogDTO blog = blogService.selectByUser(user);
		blog.setBlogTitle(blogTitle);
		blogService.updateBlog(user,blogTitle);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = postService.selectByBlog(blog);
		model.addAttribute("postlist",postlist);
		return "redirect:/basic";
	}
	
	@GetMapping("/blogUpdate")
	public String blogUpdate(Model model, String userID) {
		model.addAttribute("userID", userID);
		return "/blog/blogUpdate";
	}
	
	
}



