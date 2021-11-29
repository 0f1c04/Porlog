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
	
	//이미지 업로드
	@PostMapping(value = "/uploadImg")
	public String uploadImage(MultipartFile image) {
		try {
			return s3Service.upload(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "이미지로드실패";

	}
	
	//썸네일 업로드
	@PostMapping(value = "/uploadThumbnail")
	public String uploadThumbnail(MultipartFile image) {
		try {
			return s3Service.upload(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "이미지로드실패";
		
	}
	
	
	
	
}





