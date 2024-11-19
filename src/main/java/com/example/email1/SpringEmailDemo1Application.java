package com.example.email1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEmailDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemo1Application.class, args);
		System.out.print("你好");

		System.out.print("我是從 fork 來的, 我改好了接受我2");
	}

}
