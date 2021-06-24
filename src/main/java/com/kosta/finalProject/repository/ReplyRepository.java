package com.kosta.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.ReplyDTO;

public interface ReplyRepository extends CrudRepository<ReplyDTO, Long>, JpaRepository<ReplyDTO, Long> {
	
	public List<ReplyDTO> findByPost(PostDTO post);
	
	
	
}
