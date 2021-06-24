package com.kosta.finalProject.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jInfoController {
	@RequestMapping(value =  "/api/1", method= {RequestMethod.GET, RequestMethod.POST})
	public String callApi() throws IOException{
		StringBuilder result = new StringBuilder();
		
		String urlStr = "http://openapi.seoul.go.kr:8088/7078765043676b7333325555474e64/xml/GetJobInfo/4/31/";
		URL url = new URL(urlStr);
		
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
		String returnLine;
		System.out.println(result.toString());
		
		while((returnLine=br.readLine())!=null) {
			result.append(returnLine+"\n\r");
		}
		urlConnection.disconnect();
		
		return result.toString();
	}

}