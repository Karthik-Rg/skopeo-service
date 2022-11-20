package com.github.kr.skopeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SkopeoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkopeoServiceApplication.class, args);
	}

}
