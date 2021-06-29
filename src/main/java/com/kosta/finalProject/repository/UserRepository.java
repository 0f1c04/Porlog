package com.kosta.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.finalProject.model.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, String>, JpaRepository<UserDTO, String> {

	public UserDTO findByNickname(String nickname);

	// 아이디 중복체크
	@Query(value = "select count(*) from p_user  where user_id = ?1", nativeQuery = true)
	public int idCheck(String memberId) throws Exception;

	// 아이디찾기
	@Query(value = "select user_id from p_user  where nickname = ?1 and email =?2", nativeQuery = true)
	public String idFind(String name, String email) throws Exception;

	// 비밀번호 찾기
	@Transactional
	@Modifying
	@Query(value = "update p_user set user_pw = ?2 where user_id = ?1", nativeQuery = true)
	public int updatePW(String id, String pw) throws Exception;
}
