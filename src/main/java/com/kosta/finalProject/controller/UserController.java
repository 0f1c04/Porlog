package com.kosta.finalProject.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.security.SecurityService;
import com.kosta.finalProject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	SecurityService securityService;
	
	

	//main페이지
	@PostMapping("/index")
	public void selectUsers(Model model,Principal principal) {
	     
		
	
	}
	//main페이지
	@GetMapping("/index")
	public void selectUsers2(Model model, Principal principal) {
//		List<UserDTO> user = service.selectAll();
//		
//		model.addAttribute("user", user);
		if(principal!=null)
		     model.addAttribute("user", service.selectById(principal.getName())	);
		
	}
	
	

	
	

	

	//로그인

	
	
	//입력
	@PostMapping("/user/userInsert")
	public String userInsert(UserDTO user, RedirectAttributes rttr) {
		UserDTO ins_user = securityService.joinUser(user);
		rttr.addFlashAttribute("resultMessage", ins_user==null? "입력실패":"입력성공");
		return "redirect:/user/userSample";
	}
	
	@PostMapping("/userInsert") //오류나면 memberDTO앞에 @ModelAttribute 넣기
	public String joinProc(@ModelAttribute UserDTO user) {
		System.out.println("회원가입 : " + user);
		securityService.joinUser(user);
		return "redirect:/index";
	} 
	
	@GetMapping("/user/userInsert") 
	public void boardRegister() {
		
	}
	@GetMapping("/logout") 
	public void logout() {
		
	}
	
}
