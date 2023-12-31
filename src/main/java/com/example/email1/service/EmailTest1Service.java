package com.example.email1.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.email1.controller.dto.EmailTest1ReqResDTO;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailTest1Service {
	private Environment env;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailTest1Service(Environment env) {
		this.env = env;
	}
	
	public String process(EmailTest1ReqResDTO reqBody) {
		
		// [CASE1]: 寄送一般文字訊息
		// sendMail(reqBody.getMailAddress(), reqBody.getMailTitle(), reqBody.getMaillMessage());
		
		// [CASE2]: 寄送夾帶附件訊息
		sendMailWithAttachment(reqBody.getMailAddress(), 
				reqBody.getMailTitle(), reqBody.getMaillMessage());
		
		return "OK";
	}
	
	private Boolean sendMail(String mailAddress, String title, String messageContext) {
		
		log.info("[EmailTest1Service]: sendMail start");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(env.getProperty("spring.mail.username"));
		message.setTo(mailAddress);
		message.setSubject(title);
		message.setText(messageContext);
		
		javaMailSender.send(message);

		log.info("[EmailTest1Service]: sendMail, send mail successfully, "
				+ "(sendFrom, sendTo, title) ==> ({}, {}, {})",
				env.getProperty("spring.mail.username"),
				mailAddress, title);
		
		log.info("[EmailTest1Service]: sendMail end");
		
		return true;
	}
	
	private Boolean sendMailWithAttachment(String mailAddress, String title, String messageContext) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true); 
			helper.setFrom(env.getProperty("spring.mail.username"));
			helper.setTo(mailAddress);
			helper.setSubject(title);
			helper.setText(messageContext);
			
			// 附帶檔案
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("assets/test-img1.jpg").getFile());
			FileSystemResource resultFile = new FileSystemResource(file);
			helper.addAttachment("附件1-tenshsama.jpg", resultFile);
			
			javaMailSender.send(message);
			
			return true;
		} catch (Exception error) {
			error.printStackTrace();
			return false;
		}
		
	}
}
