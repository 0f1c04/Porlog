package com.kosta.finalProject.security;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.UserRepository;


@Service
public class SecurityService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	PasswordEncoder passwordEncoder; // security config에서 Bean생성
	
	
	@Transactional
	public UserDTO joinUser(UserDTO user) {
		// 비밀번호 암호화...암호화되지않으면 로그인되지않는다.
		user.setUserPW(passwordEncoder.encode(user.getUserPW()));
		// member.setMrole(MemberRoleEnumType.USER);
		System.out.println(passwordEncoder.encode(user.getUserPW()));
		return repo.save(user);
	}
	
	
	//반드시 구현
	@Override
	public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
		System.out.println("security 후 userID" + userID);
		UserDetails user = repo.findById(userID)
				.filter(u -> u != null).map(u -> new SecurityUser(u)).get();
		System.out.println("security 후 유저 : "+user);
		return user;
	}
	
	
	

}



