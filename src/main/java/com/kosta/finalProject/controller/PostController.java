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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	
	int aa=0;
	@RequestMapping(value = "/likepost", method = RequestMethod.POST)
	@ResponseBody
	public int updatepw(@RequestParam("blogID") String bid, 
			@RequestParam ("postID") Long pid, @RequestParam("pcheck") int check,
			@RequestParam("ucheck") int ucheck,@RequestParam("uid") String uid) throws Exception {
		System.out.println("아이디임:"+pid);
		System.out.println("check의 값은: "+check);
		int a=1;
		int b=-1;
		
		if(check==0 ) {	
			aa=service.LikeUp(pid, a);
		}
		else {
			aa=service.LikeDown(pid,b);
			aa=0;
		}
		return aa;
	}
	
	
	// 게시글 리스트 (선택된 블로그ID에 해당하는 게시글들을 불러온다.)
	@GetMapping("/postList")
	public String selectByBlog(Model model, Long blogID, Principal principal) {
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("postlist", service.selectByBlog(blog));
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("blogID", blogID);
		model.addAttribute("blog", blog);
		return "/postList";
	}

	// 게시글 작성
	@PostMapping("/postInsert")
	public String postInsert(Model model, Long blogID, String postTitle, String postContents, String postThumbnail,
			Principal principal) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		//날짜와 제목을 넣어 postDTO 생성
		PostDTO post = PostDTO.builder().postTitle(postTitle).postDate(dateformat.format(time))
				.postThumbnail(postThumbnail).build();
		PostDTO ins_post = service.insertPost(post, blogID);
		//생성된 post로 postContentsDTO 생성
		Post_ContentsDTO postContentDTO = Post_ContentsDTO.builder().contents(postContents).post(ins_post).build();
		serviceC.insertPostContents(postContentDTO);
		//basic페이지에 필요한 blog, postlist, user설정
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = service.selectByBlog(blog);
		model.addAttribute("postlist", postlist);
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		return "/basic";
	}
	
	// 게시물 수정
	@PostMapping("/postUpdate")
	public String postUpdate(Model model, Long blogID, String postTitle, String postContents, String postThumbnail,
			Principal principal) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		//날짜와 제목을 넣어 postDTO 생성
		PostDTO post = PostDTO.builder().postTitle(postTitle).postDate(dateformat.format(time))
				.postThumbnail(postThumbnail).build();
		PostDTO ins_post = service.insertPost(post, blogID);//고치자
		//업데이트된 post로 postContentsDTO 생성
		Post_ContentsDTO postContentDTO = Post_ContentsDTO.builder().contents(postContents).post(ins_post).build();
		serviceC.updatePostContents(postContentDTO);
		//basic페이지에 필요한 blog, postlist, user설정
		BlogDTO blog = serviceB.selectById(blogID);
		model.addAttribute("myblog", blog);
		List<PostDTO> postlist = service.selectByBlog(blog);
		model.addAttribute("postlist", postlist);
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		return "/basic";
	}

	@GetMapping("/posting")
	public void postInsert(Model model, Long blogID, Long postID, Principal principal) {
		model.addAttribute("user", serviceU.selectById(principal.getName()));
		model.addAttribute("blogID", blogID);
		model.addAttribute("postID", postID);
	}

	// 게시물 삭제
	@GetMapping("/postDelete")
	public String postDelete(Long postID, Principal principal) {
		int result = service.deletePost(postID);
		System.out.println(result + "건의 게시물 삭제");
		return "redirect:/basic?userID=" + principal.getName();
	}
}
