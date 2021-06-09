package com.kosta.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	// 입력
	public UserDTO insertUser(UserDTO user) {
		return repo.save(user);
	}
	
	// 수정
	
	// 삭제
//	public int deleteUser(String userId) {
//		
//	}
	
	// 조회
	public List<UserDTO> selectAll() {
		List<UserDTO> user = repo.findAll();
		return user;
	}
}
