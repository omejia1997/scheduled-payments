package com.banquito.schedulepayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulepaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulepaymentApplication.class, args);
	}

	

}
