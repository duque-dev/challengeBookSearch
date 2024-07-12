package com.alurapractice.challengebooksearch;

import com.alurapractice.challengebooksearch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengebooksearchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChallengebooksearchApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.setMenu();




	}
}
