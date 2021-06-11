package com.kosta.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;

public interface PostRepository extends CrudRepository<PostDTO, Long>, JpaRepository<PostDTO, Long>{
	
	public List<PostDTO> findByBlog(BlogDTO blog);
}
