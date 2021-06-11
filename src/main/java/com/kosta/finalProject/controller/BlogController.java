package com.kosta.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostService;
import com.kosta.finalProject.service.UserService;

@Controller
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@Autowired
	PostService serviceP;
	
	
	@GetMapping("/blogList")
	public String selectUsers(Model model) {
		model.addAttribute("bloglist", service.selectAll());
		//model.addAttribute("postlist", serviceP.selectByBlog(blog));
		//System.out.println(blog);
		return "/blogList";
	}
	
	
	@PostMapping("/blogInsert")
	public String blogInsert(UserDTO user, RedirectAttributes rttr) {
//		UserDTO ins_user = service.insertUser(user);
//		rttr.addFlashAttribute("resultMessage", ins_user==null? "입력실패":"입력성공");
		return "redirect:/userSample";
	}
	
	@GetMapping("/blogInsert")
	public void blogInsert() {
		
	}
	
}
