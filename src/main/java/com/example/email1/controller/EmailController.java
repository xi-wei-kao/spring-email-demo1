package com.example.email1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email1.controller.dto.EmailTest1ReqResDTO;
import com.example.email1.service.EmailTest1Service;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailTest1Service emailTest1Service;
	
	@PostMapping(path = "/test1")
	public String getEmailTest1(@RequestBody EmailTest1ReqResDTO reqBody) {
		
		return emailTest1Service.process(reqBody);
	}
	
}
