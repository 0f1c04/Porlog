package com.kosta.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@GetMapping("/userSample")
	public void selectUsers(Model model) {
		List<UserDTO> user = service.selectAll();
		
		model.addAttribute("user", user);
	}
	
	
	@PostMapping("/userInsert")
	public String userInsert(UserDTO user, RedirectAttributes rttr) {
		UserDTO ins_user = service.insertUser(user);
		rttr.addFlashAttribute("resultMessage", ins_user==null? "입력실패":"입력성공");
		return "redirect:/userSample";
	}
	
	@GetMapping("/userInsert")
	public void boardRegister() {
		
	}
	
}
