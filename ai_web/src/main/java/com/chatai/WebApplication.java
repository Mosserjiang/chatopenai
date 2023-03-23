package com.chatai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mosserjiang
 * @date 2023-03-22
 */
@SpringBootApplication(scanBasePackages = "com.chatai")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
