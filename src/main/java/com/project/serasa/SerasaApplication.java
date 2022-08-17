package com.project.serasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SerasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerasaApplication.class, args);
	}

}
