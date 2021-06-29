package com.kosta.finalProject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.finalProject.service.S3FileUploadService;

@RestController
public class EditorController {

	@Autowired
	S3FileUploadService s3Service;

	// , consumes = {MediaType.APPLICATION_JSON_VALUE}
	@PostMapping(value = "/uploadImg")
	public String uploadImage(MultipartFile image) {
		// System.out.println("들어왔음" + http);
		// MultipartHttpServletRequest request2 = (MultipartHttpServletRequest) http;
		// System.out.println(request2.getFile("image"));

		System.out.println("uploadImage왔음 : " + image);
		try {
			return s3Service.upload(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "이미지로드실패";

	}
}
