package com.kosta.finalProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.UserRepository;
import com.kosta.finalProject.security.SecurityUser;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	
	
	
	
	//회원가입
	// 입력, 일단 아이디가 중복되는 경우 null값 return
//	public UserDTO insertUser(UserDTO user) {
//		System.out.println("user : "+repo.findById(user.getUserID()).get());
//		if(repo.findById(user.getUserID()).get() == null) {
//			return repo.save(user);
//		}
//		else if(user.equals(repo.findById(user.getUserID()).get())){
//			return null;
//		}
		//비밀번호 암호화
//		user.setUserPW(passwordEncoder.encode(user.getUserPW()));
//		return repo.save(user);
		
//	}
	
	// 수정
	public UserDTO updateUser(UserDTO user) {
		return repo.save(user);
	}
	
	// 삭제
	public int deleteUser(String userID) {
		int result = 0;
		try {
			repo.deleteById(userID);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	// 모두조회
	public List<UserDTO> selectAll() {
		List<UserDTO> user = repo.findAll();
		return user;
	}
	
	//아이디로 조회
	public UserDTO selectById(String userID) {
		return repo.findById(userID).get();
	}

	
}
