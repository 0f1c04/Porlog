package com.kosta.finalProject.controller;



import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.kosta.finalProject.service.UserService;



@Controller
public class PostController {
	
	@Autowired
	PostService service;
	@Autowired
	PostContentsService serviceC;
	@Autowired
	BlogService serviceB;
	@Autowired
	UserService serviceU;
	
	
	@GetMapping("/postList")
	public String selectByBlog(Model model, Long blogID, String userID, Principal principal) {
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("postlist", service.selectByBlog(blog));
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("blogID", blogID);
		model.addAttribute("blog", blog);
		return "/postList";
	}
	
	@PostMapping("/postInsert")
	public String postInsert(Model model,  Long blogID, String postTitle, String postContents, Principal principal) {
		System.out.println("내용  "+postContents);
		System.out.println("blogID"+blogID);
		System.out.println("postTitle"+postTitle);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		
		PostDTO post = PostDTO.builder().postTitle(postTitle).postDate(dateformat.format(time)).build();
		PostDTO ins_post = service.insertPost(post, blogID);
		Post_ContentsDTO postContentDTO = Post_ContentsDTO.builder().contents(postContents).post(ins_post).build();
		serviceC.insertPostContents(postContentDTO);
		
		
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = service.selectByBlog(blog);
		model.addAttribute("postlist",postlist);
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		return "/basic";
	} 
	
	
	/*
	 * @PostMapping("/postInsert") public String postInsert(PostDTO post,
	 * Post_ContentsDTO postC, Long blogID, RedirectAttributes rttr) { PostDTO
	 * ins_post = service.insertPost(post, blogID); Post_ContentsDTO ins_postC =
	 * serviceC.insertPostContents(postC); rttr.addFlashAttribute("resultMessage",
	 * ins_post==null? "입력실패":"입력성공"); rttr.addFlashAttribute("resultMessage",
	 * ins_postC==null? "컨텐츠입력실패":"컨텐츠입력성공"); return "redirect:/blogList"; }
	 */

	@GetMapping("/posting")
	public void postInsert(Model model, Long blogID, Long postID, Principal principal) {
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("blogID", blogID);
		model.addAttribute("postID", postID);
	}
	
	@GetMapping("/postDelete")
	public String postDelete(Long postID, Post_ContentsDTO postc) {
		int result = service.deletePost(postID);
		System.out.println(result + "건의 게시물 삭제");
		return "redirect:/blogList";
	}
}
