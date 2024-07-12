package com.alurapractice.challengebooksearch;

import com.alurapractice.challengebooksearch.principal.Principal;
import com.alurapractice.challengebooksearch.repository.IAutorRepository;
import com.alurapractice.challengebooksearch.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengebooksearchApplication implements CommandLineRunner{

	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private IAutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(ChallengebooksearchApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(bookRepository, autorRepository);
		principal.setMenu();




	}
}
