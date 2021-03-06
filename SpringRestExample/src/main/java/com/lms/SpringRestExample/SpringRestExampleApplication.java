package com.lms.SpringRestExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="com.techm.*")
@SpringBootApplication
public class SpringRestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExampleApplication.class, args);
	}
}
