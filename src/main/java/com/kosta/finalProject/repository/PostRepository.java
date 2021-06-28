package com.kosta.finalProject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;

public interface PostRepository extends CrudRepository<PostDTO, Long>, JpaRepository<PostDTO, Long>{
	
	public List<PostDTO> findByBlog(BlogDTO blog);
	
	@Query(value = "select * from P_POST where POST_ID = (select MAX(POST_ID) from P_POST)", nativeQuery = true)
	public PostDTO findByPostIdMaxVal();
	
	@Transactional
	@Modifying
	@Query("update PostDTO p set p.viewCnt = p.viewCnt + 1 where p.postID = :postID")
	public int HitViewCount(Long postID);
	
	
}
