package com.kosta.finalProject.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.kosta.finalProject.model.BlogDTO;

import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostService;



@Controller
public class PostController {
	
	@Autowired
	PostService service;
	@Autowired
	BlogService serviceB;
	
	
	@GetMapping("/postList")
	public String selectByBlog(Model model, Long blogID) {
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("postlist", service.selectByBlog(blog));
		return "/postList";
	}
//	@GetMapping("/postList/{blogID}")
//	public ResponseEntity<List<PostDTO>> selectAll(@PathVariable Long blogID) {
//		BlogDTO blog = BlogDTO.builder().blogID(blogID).build();
//		return new ResponseEntity<>(service.selectByBlog(blog),HttpStatus.OK);
//	}
	
/*	
	@PostMapping("/blogInsert")
	public String blogInsert(UserDTO user, RedirectAttributes rttr) {
		UserDTO ins_user = service.insertUser(user);
		rttr.addFlashAttribute("resultMessage", ins_user==null? "입력실패":"입력성공");
		return "redirect:/userSample";
	}
	
	@GetMapping("/blogInsert")
	public void blogInsert() {
		
	}
	*/
	
}
