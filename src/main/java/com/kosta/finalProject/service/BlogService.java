package com.kosta.finalProject.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.repository.BlogRepository;

@Service
public class BlogService {
	
	@Autowired
	BlogRepository repo;
	
	//조회
	public List<BlogDTO> selectAll(){
		List<BlogDTO> blog = repo.findAll();
		//System.out.println(blog);
		return blog;
	}
	public BlogDTO selectById(Long blogid) {
		return repo.findById(blogid).get();
	}
	
	//입력
	public BlogDTO insertBlog(BlogDTO blog){
		return repo.save(blog);
	}
	
	
	
}






