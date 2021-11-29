package com.kosta.finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.kosta"})
@Controller
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}
	
	@RequestMapping( "/jInfo" )
	public String home2() {
		return "jInfo";
	}
	
	
	
}
