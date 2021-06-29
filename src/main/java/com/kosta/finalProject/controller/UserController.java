package com.kosta.finalProject.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosta.finalProject.email.CustomMailSender;
import com.kosta.finalProject.model.UserDTO;
import com.kosta.finalProject.security.SecurityService;
import com.kosta.finalProject.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	SecurityService securityService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	CustomMailSender customMailSender;

	// main페이지
	@PostMapping("/index")
	public void selectUsers(Model model, Principal principal) {

	}

	// main페이지
	@GetMapping("/index")
	public void selectUsers2(Model model, Principal principal) {
		if (principal != null)
			model.addAttribute("user", service.selectById(principal.getName()));
	}

	// 유저 상세정보
	@GetMapping("/userDetail")
	public void userDetail(Model model, Principal principal) {
		model.addAttribute("user", service.selectById(principal.getName()));
	}

	// 입력
	@PostMapping("/user/userInsert")
	public String userInsert(UserDTO user, RedirectAttributes rttr) {
		UserDTO ins_user = securityService.joinUser(user);
		rttr.addFlashAttribute("resultMessage", ins_user == null ? "입력실패" : "입력성공");
		return "redirect:/user/userSample";
	}

	@PostMapping("/userInsert") // 오류나면 memberDTO앞에 @ModelAttribute 넣기
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

//  아이디 중복체크 별 기능들 여긷가ㅏ
	@RequestMapping(value = "/ID_Check", method = RequestMethod.POST)
	@ResponseBody
	public int IdCheck(@RequestBody String memberId) throws Exception {

		int count = 0;
		System.out.println(memberId);
		count = service.idCheck(memberId);

		return count;
	}
	// 아이디 찾기

	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	@ResponseBody
	public String IdFind(@RequestParam("idName") String username, @RequestParam("idEmail") String email)
			throws Exception {

		String count = service.idFind(username, email);

		return count;
	}

	// 비밀번호찾기
	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> PWFind(@RequestParam("cname") String username, @RequestParam("cemail") String email,
			Model model) throws Exception {

		Map rmap = new HashMap<String, Object>();

		String pass[] = new String[email.length()];
		String result = "";
		for (int i = 0; i < email.length(); i++) {
			pass[i] = email.substring(i, i + 1);
			pass[i] = String.valueOf(pass[i].hashCode());
			pass[i] = pass[i].substring(0, 1);
			result = result + pass[i];
		}
		System.out.println(result);

		customMailSender.sendMail(email, result);

		String count = service.idFind(username, email);

		rmap.put("test1", result);

		rmap.put("test2", count);

		return rmap;
	}

	// 인증번호 인증
	@RequestMapping(value = "/changepw", method = RequestMethod.POST)
	@ResponseBody
	public String PWchange(@RequestParam("enumber") String enumber) throws Exception {
		System.out.println(enumber);

		return enumber;
	}

	// 비밀번호 재설정
	@RequestMapping(value = "/setpwform", method = RequestMethod.POST)
	@ResponseBody
	public String updatepw(@RequestParam("requireID") String id, @RequestParam("setPW") String pw) throws Exception {

		String enpw = passwordEncoder.encode(pw);

		service.updatePW(id, enpw);

		String count = "";
		return count;

	}
}
