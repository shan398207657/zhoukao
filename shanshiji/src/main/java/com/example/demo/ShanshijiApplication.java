package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ssj")
public class ShanshijiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShanshijiApplication.class, args);
	}

}
