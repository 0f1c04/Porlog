package com.kosta.finalProject.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.Post_ContentsDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostContentsService;
import com.kosta.finalProject.service.PostService;



@Controller
public class PostController {
	
	@Autowired
	PostService service;
	@Autowired
	PostContentsService serviceC;
	@Autowired
	BlogService serviceB;
	
	
	@GetMapping("/postList")
	public String selectByBlog(Model model, Long blogID) {
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("postlist", service.selectByBlog(blog));
		model.addAttribute("blogID", blogID);
		model.addAttribute("blog", blog);
		return "/postList";
	}
	
	@PostMapping("/postInsert")
	public String postInsert(PostDTO post, Post_ContentsDTO postC, Long blogID, RedirectAttributes rttr) {
		PostDTO ins_post = service.insertPost(post, blogID);
		Post_ContentsDTO ins_postC = serviceC.insertPostContents(postC);
		rttr.addFlashAttribute("resultMessage", ins_post==null? "입력실패":"입력성공");
		rttr.addFlashAttribute("resultMessage", ins_postC==null? "컨텐츠입력실패":"컨텐츠입력성공");
		return "redirect:/blogList";
	}

	@GetMapping("/posting")
	public void postInsert(Model model, Long blogID, Long postID) {
		model.addAttribute("blogID", blogID);
		model.addAttribute("postID", postID);
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
