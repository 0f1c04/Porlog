package com.kosta.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.PostDTO;

public interface PostRepository extends CrudRepository<PostDTO, Long>, JpaRepository<PostDTO, Long>{
	
	@Query(value = "select * from P_POST where blog_blog_id = ? order by 1 desc", nativeQuery = true)
	public List<PostDTO> findByBlog(BlogDTO blog);
	
	@Query(value = "select * from P_POST where POST_ID = (select MAX(POST_ID) from P_POST)", nativeQuery = true)
	public PostDTO findByPostIdMaxVal();
	
	
	@Transactional
	@Modifying
	@Query("update PostDTO p set p.viewCnt = p.viewCnt + 1 where p.postID = :postID")
	public int HitViewCount(Long postID);
	
	@Transactional
	@Modifying
	@Query("update PostDTO p set p.likeCnt = p.likeCnt + ?2 where p.postID = ?1")
	public int HitLikeUpDown(Long postID, int like);
	
	@Transactional
	@Modifying
	@Query("delete from PostDTO p where p.postID = :postID")
	public int deleteByPostId(Long postID);
}
