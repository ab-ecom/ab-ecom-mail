package com.anirudhb2b.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AbEcomMailApplication {
	public static void main(String[] args) {
		SpringApplication.run(AbEcomMailApplication.class, args);
	}
}
