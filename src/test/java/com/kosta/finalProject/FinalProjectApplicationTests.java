package com.kosta.finalProject;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.repository.UserRepository;

@SpringBootTest
class FinalProjectApplicationTests {

	@Autowired
	UserRepository repo;
	
	@Test
	public void insertUser() {
		UserDTO user = new UserDTO();
		user.setUserID("테스트ID(2)");
		user.setUserPW("1234");
		user.setEmail("테스트Email");
		user.setNickname("테스트닉넴");
		user.setLastLogin(new Date());
		user.setLastPWChg(new Date());
		user.setAuthLV(1);
		repo.save(user);
	}
	
}
