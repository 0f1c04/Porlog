package com.kosta.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.finalProject.model.LikeDTO;
import com.kosta.finalProject.service.LikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LikeController {
	@Autowired
	LikeService lservice;
	
	/*
	 * @PostMapping("/like/{postID}") public ResponseEntity<String> addLike(
	 * 
	 * @AuthenticationPrincipal UserAdapter userAdapter,
	 * 
	 * @PathVariable Long postID) {
	 * 
	 * boolean result = false;
	 * 
	 * if (userAdapter != null) { result = lservice.addLike(userAdapter.getUser(),
	 * postID); }
	 * 
	 * return result ? new ResponseEntity<>(HttpStatus.OK) : new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
	 */
	
}
