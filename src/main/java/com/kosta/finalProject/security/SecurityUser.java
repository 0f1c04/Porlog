package com.kosta.finalProject.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.kosta.finalProject.model.UserDTO;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class SecurityUser extends User{
	
	private static final long serialVersionUID = 1L;
	private static final String ROLE_PREFIX="ROLE_";
    private UserDTO user;   
    
	public SecurityUser(String userID, String userPW, Collection<? extends GrantedAuthority> authorities) {
		super(userID, userPW, authorities);
		System.out.println("username = " + userID);
	}
	public SecurityUser(UserDTO user) {	
		super(user.getUserID(), user.getUserPW(), makeRole(user)  );
		this.user = user;
		System.out.println("security member : " + user);
	}
	
	//Role을 여러개 가질수 있도록 되어있음 
	private static List<GrantedAuthority> makeRole(UserDTO member) {
		List<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(new SimpleGrantedAuthority(ROLE_PREFIX + member.getAuthLV()));
		return roleList;
	}

}









