package com.example.practicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class PracticeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeBackendApplication.class, args);
		System.out.println("server start");
	}

}
