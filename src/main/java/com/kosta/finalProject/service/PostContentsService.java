package com.kosta.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.Post_ContentsDTO;
import com.kosta.finalProject.repository.PostContentsRepository;
import com.kosta.finalProject.repository.PostRepository;

@Service
public class PostContentsService {
	
	@Autowired
	PostContentsRepository repo;
	
	@Autowired
	PostRepository Postrepo;
	
	//조회
	public Post_ContentsDTO selectByPost(PostDTO post) {
		return repo.findByPost(post);
	}
	
	// 입력
	public Post_ContentsDTO insertPostContents(Post_ContentsDTO postC) {
		PostDTO post = Postrepo.findByPostIdMaxVal();
		postC.setPost(post);
		return repo.save(postC);
	}
	
	// 수정
	public Post_ContentsDTO updatePostContents(Post_ContentsDTO postC) {
		return repo.save(postC);
	}
}
