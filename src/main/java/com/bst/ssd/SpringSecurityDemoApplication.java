package com.bst.ssd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringSecurityDemoApplication.class, args);
		System.out.println("Tomcat Running ...");
	}
}
