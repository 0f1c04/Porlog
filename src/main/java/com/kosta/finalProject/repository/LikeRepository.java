package com.kosta.finalProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.LikeDTO;
import com.kosta.finalProject.model.PostDTO;
import com.kosta.finalProject.model.UserDTO;

public interface LikeRepository extends CrudRepository<LikeDTO, Long>, JpaRepository<LikeDTO, Long>{
	
	Optional<LikeDTO> findByUserAndPost(UserDTO user, PostDTO post);
}
