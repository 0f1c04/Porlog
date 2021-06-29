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
	
	//닉네임으로 조회
	public UserDTO selectByNick(String nickname) {
		return repo.findByNickname(nickname);
	}

	//아이디중복체크
    public int idCheck(String memberId) throws Exception {
        
        return repo.idCheck(memberId);
    } 
    //아이디 찾기
    public String idFind(String name,String email) throws Exception {
        
        return repo.idFind(name,email);
    } 
    //비밀번호 재설정
    public int updatePW(String id,String pw) throws Exception {
      
         
         return repo.updatePW(id,pw);
    } 
	
}
