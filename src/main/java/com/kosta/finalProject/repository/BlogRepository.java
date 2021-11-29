package com.kosta.finalProject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.kosta.finalProject.model.BlogDTO;
import com.kosta.finalProject.model.UserDTO;

public interface BlogRepository extends CrudRepository<BlogDTO, Long>, JpaRepository<BlogDTO, Long>, QuerydslPredicateExecutor<BlogDTO>{
	
	public BlogDTO findByUser(UserDTO user);  
	
	@Query(value = "select nvl(blog_id, 0) as blog_id, nvl(user_user_id, ?1) as user_user_id, nvl(blog_title,'새 폴로그를 만들어주세요') as blog_title from p_blog right outer join DUAL on user_user_id= ?1",
			nativeQuery = true)
	public BlogDTO findByUser2(UserDTO user);  
	
	@Transactional
	@Modifying
	@Query(value = "update p_blog set blog_title = ?2 where user_user_id = ?1",
			nativeQuery = true)
	public int updateBlog(UserDTO user, String blogTitle);
	
}
