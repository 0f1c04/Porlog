package com.kosta.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.UserService;


@Controller
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@Autowired
	UserService userService;
	

	
	
	@GetMapping("/blogList")
	public String selectUsers(Model model) {
		model.addAttribute("bloglist", service.selectAll());
		return "blogList";
	}
	
	
	@PostMapping("/blogInsert")
	public String blogInsert(UserDTO user, RedirectAttributes rttr) {
//		UserDTO ins_user = service.insertUser(user);
//		rttr.addFlashAttribute("resultMessage", ins_user==null? "입력실패":"입력성공");
		return "redirect:/userSample";
	}
	
	@GetMapping("/blogInsert")
	public void blogInsert(Model model, Long blogID) {
		model.addAttribute("blogID", blogID);
	}
	
//	@GetMapping("/basic")
//	public String selectById(Model model, String userID) {
//		System.out.println("넘어온 user : "+userID);
//		UserDTO user = serviceU.selectById(userID);
//		model.addAttribute("myblog", service.selectByUser(user));
//		return "/basic"; 
//	}
	@GetMapping("/basic")
	public String selectById(Model model) {
		//System.out.println("넘어온 user : "+userID);
		String userID;
		userID = "yoonho3";
		UserDTO user = userService.selectById(userID);
		BlogDTO blog = service.selectByUser(user);
		model.addAttribute("myblog", blog);
		return "/basic"; 
	}
}
