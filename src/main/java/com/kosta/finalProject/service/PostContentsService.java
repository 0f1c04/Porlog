package com.kosta.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.Post_ContentsDTO;
import com.kosta.finalProject.repository.PostContentsRepository;

@Service
public class PostContentsService {
	
	@Autowired
	PostContentsRepository repo;
	
	// 입력
	public Post_ContentsDTO insertPostContents(Post_ContentsDTO postC) {
		return repo.save(postC);
	}
	
	// 수정
	public Post_ContentsDTO updatePostContents(Post_ContentsDTO postC) {
		return repo.save(postC);
	}
}
