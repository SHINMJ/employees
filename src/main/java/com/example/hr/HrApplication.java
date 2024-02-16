package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

}
