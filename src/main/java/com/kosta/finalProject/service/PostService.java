package com.kosta.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repo;

	// 조회
	public List<PostDTO> selectByBlog(BlogDTO blog) {
		return repo.findByBlog(blog);
	}

}
