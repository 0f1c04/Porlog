package com.kosta.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.Post_ContentsDTO;

public interface PostContentsRepository extends CrudRepository<Post_ContentsDTO, Long>, JpaRepository<Post_ContentsDTO, Long> {
	public Post_ContentsDTO findBypostID(Long postid);
}
