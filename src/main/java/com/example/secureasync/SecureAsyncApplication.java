package com.example.secureasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SecureAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureAsyncApplication.class, args);
	}

}
