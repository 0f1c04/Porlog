package com.kosta.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.Post_ContentsDTO;

public interface PostContentsRepository extends CrudRepository<Post_ContentsDTO, Long>, JpaRepository<Post_ContentsDTO, Long> {
	public Post_ContentsDTO findByPost(PostDTO post);
	
	@Transactional
	@Query("delete from Post_ContentsDTO c where c.postcID = :postcID")
	public int deleteByContentsId(Long postcID);
}
