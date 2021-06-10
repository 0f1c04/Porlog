package com.kosta.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.ReplyDTO;
import com.kosta.finalProject.service.ReplyService;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	
	@Autowired
	ReplyService service;
	
	// 댓글모두조회
	@GetMapping("/post/{postID}")
	public ResponseEntity<List<ReplyDTO>> selectAll(@PathVariable Long postID) {
		PostDTO post = PostDTO.builder().postID(postID).build();
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글입력
	@PostMapping("/{postID}")
	public ResponseEntity<List<ReplyDTO>> insertReply(@PathVariable Long postID, @RequestBody ReplyDTO reply) {
		PostDTO post = PostDTO.builder().postID(postID).build();
		reply.setPost(post);
		service.updateReply(reply);
		
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.CREATED);
	}
	
	// 댓글삭제
	@DeleteMapping("/{postID}/{replyNO}")
	public ResponseEntity<List<ReplyDTO>> deleteByRno(@PathVariable Long replyNO, @PathVariable Long postID) {
		service.deleteReply(replyNO);
		PostDTO post = PostDTO.builder().postID(postID).build();
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글수정
	@PutMapping("/{postID}")
	public ResponseEntity<List<ReplyDTO>> updateReply(@PathVariable Long postID, @RequestBody ReplyDTO reply) {
		PostDTO post = PostDTO.builder().postID(postID).build();
		reply.setPost(post);
		service.updateReply(reply);
		return new ResponseEntity<>(service.selectAll(post), HttpStatus.OK);
	}
	
	// 댓글상세보기
	@GetMapping("/{replyNO}")
	public ResponseEntity<ReplyDTO> detailReply(@PathVariable Long replyNO) {
		return new ResponseEntity<>(service.selectByNo(replyNO), HttpStatus.OK);
	}
}
