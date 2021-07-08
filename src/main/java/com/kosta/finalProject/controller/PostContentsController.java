package com.kosta.finalProject.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.Post_ContentsDTO;
import com.kosta.finalProject.service.BlogService;
import com.kosta.finalProject.service.PostContentsService;
import com.kosta.finalProject.service.PostService;
import com.kosta.finalProject.service.UserService;


@Controller
public class PostContentsController {
	
	@Autowired
	PostContentsService service;
	@Autowired
	PostService serviceP;
	@Autowired
	BlogService serviceB;
	@Autowired
	UserService serviceU;
	
	// 게시글 상세내용보기 (선택된 게시글ID에 해당하는 게시글의 상세내용을 보여준다.)
	@GetMapping("/postDetail")
	public String selectByPost(Model model, Long postID, Long blogID, Principal principal) {
		PostDTO post = serviceP.selectByPostId(postID);
		model.addAttribute("postcontent", service.selectByPost(post));
		model.addAttribute("postID", postID);
		model.addAttribute("blogID", blogID);
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("view", serviceP.HitCount(postID));
		return "/postDetail";
	}
	
	// 게시글 상세내용보기2 (내 폴로그에서 포스트를 클릭할 시 나오게 될 게시글상세내용)
		@GetMapping("/postDetail2")
		public String selectByMyPost(Model model, Long postID, Long blogID, Principal principal) {
			PostDTO post = serviceP.selectByPostId(postID);
			model.addAttribute("postcontent", service.selectByPost(post));
			model.addAttribute("postID", postID);
			model.addAttribute("blogID", blogID);
			model.addAttribute("user", serviceU.selectById(principal.getName()));
			model.addAttribute("view", serviceP.HitCount(postID));
			return "/postDetail2";
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
	
	//게시물수정(Get)
	@GetMapping("/postUpdate")
	public String updateByPost(Model model, Long postID,String contents, Long blogID, Principal principal) {
		PostDTO post = serviceP.selectByPostId(postID);
		
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("post", post);
		model.addAttribute("contents", contents);
		model.addAttribute("blogID", blogID);
		return "/postUpdate";
	} 
	
	// 게시글수정
	@PostMapping("/postupdate")
	public String postUpdate(Post_ContentsDTO postC, RedirectAttributes rttr) {
		Post_ContentsDTO update_post = service.updatePostContents(postC);
		rttr.addFlashAttribute("resultMessage", update_post == null ? "수정실패":"수정성공");
		return "redirect:/post";
	}
	
	// 게시글삭제
	@GetMapping("/postContentsDelete")
	public String postDelete(Long postcID, Principal principal) {
		int result = service.deletePostContents(postcID);
		System.out.println(result + "건의 컨텐츠 삭제");
		return "redirect:/basic?userID=" + principal.getName();
	}
}
