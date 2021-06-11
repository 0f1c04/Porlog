package com.kosta.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.Post_ContentsDTO;
import com.kosta.finalProject.service.PostContentsService;

@Controller
public class PostContentsController {
	
	@Autowired
	PostContentsService service;
	
	@GetMapping("/postDetail")
	public String selectByBlog(Model model, Long postID) {
		model.addAttribute("postcontent", service.selectByPostid(postID));
		return "/postDetail";
	}
	
	// 게시글입력페이지(Get)
	@GetMapping("/postContents")
	public void postContents() {
		
	}
	
	// 게시글입력(Post)
	@PostMapping("/postContents")
	public String posting(Post_ContentsDTO postC, RedirectAttributes rttr) {
		Post_ContentsDTO postingC = service.insertPostContents(postC);
		rttr.addFlashAttribute("resultMessage", postingC == null? "포스팅성공":"포스팅성공");
		return "redirect:/post";
	}
	
	// 게시글수정
	@PostMapping("/postupdate")
	public String postUpdate(Post_ContentsDTO postC, RedirectAttributes rttr) {
		Post_ContentsDTO update_post = service.updatePostContents(postC);
		rttr.addFlashAttribute("resultMessage", update_post == null ? "수정실패":"수정성공");
		return "redirect:/post";
	}
}
