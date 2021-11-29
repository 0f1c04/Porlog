
package com.kosta.finalProject.email;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class CustomMailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendMail(String email,String key) throws MessagingException,IOException{
	MimeMessage message = javaMailSender.createMimeMessage(); 
	MimeMessageHelper helper = new 	MimeMessageHelper(message,true);
  
  //메일 제목 설정
	helper.setSubject("비밀번호 찾기 인증번호");
  	helper.setFrom("kha0202kha@naver.com"); //수신자설정
 	helper.setTo(email); //템플릿에 전달할 데이터 설정 
 	Context context = new Context();
 	
 	context.setVariable("test_key", key); //메일 내용 설정: 템플릿  프로세스
 	String html = templateEngine.process("mail-template", context);
  	helper.setText(html,true);
  //메일 보내기
 	javaMailSender.send(message);
  
  }
}
