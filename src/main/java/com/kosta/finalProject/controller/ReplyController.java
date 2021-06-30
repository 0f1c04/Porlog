package com.kosta.finalProject.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.ReplyDTO;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.service.ReplyService;
import com.kosta.finalProject.service.UserService;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	
	@Autowired
	ReplyService service;
	@Autowired
	UserService uservice;
	
	// 댓글모두조회
	@GetMapping("/post/{postID}")
	public ResponseEntity<List<ReplyDTO>> selectAll(@PathVariable Long postID) {
		PostDTO post = PostDTO.builder().postID(postID).build();
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글입력
	@PostMapping("/{postID}")
	public ResponseEntity<List<ReplyDTO>> insertReply(@PathVariable Long postID, String reply, Principal principal) {
		System.out.println(postID);
		System.out.println(reply);
		System.out.println(principal.getName());
		PostDTO post = service.selectByPost(postID);
		UserDTO user = uservice.selectById(principal.getName());
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		ReplyDTO newreply = ReplyDTO.builder().post(post).reply(reply).replyUser(user).replyDate(dateformat.format(time)).build();
		
		service.updateReply(newreply);
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.CREATED);
	}
	
	// 댓글삭제
	@DeleteMapping("/{postID}/{replyNO}")
	public ResponseEntity<List<ReplyDTO>> deleteByRno(@PathVariable Long replyNO, @PathVariable Long postID) {
		System.out.println(replyNO);
		System.out.println(postID);
		PostDTO post = new PostDTO();
		post.setPostID(postID);
		
		service.deleteReply(replyNO);
		
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글수정
	@PutMapping("/{postID}")
	public ResponseEntity<List<ReplyDTO>> updateReply(@PathVariable Long postID, String reply, String replyUser, Long replyNO) {
		System.out.println(replyUser);
		PostDTO post = service.selectByPost(postID);
		UserDTO user = uservice.selectByNick(replyUser);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		ReplyDTO newreply = ReplyDTO.builder().replyNO(replyNO).post(post).reply(reply).replyUser(user).replyDate(dateformat.format(time)).build();
		
		service.updateReply(newreply);
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글상세보기
	@GetMapping("/{replyNO}")
	public ResponseEntity<ReplyDTO> detailReply(@PathVariable Long replyNO) {
		return new ResponseEntity<>(service.selectByNo(replyNO), HttpStatus.OK);
	}
}
