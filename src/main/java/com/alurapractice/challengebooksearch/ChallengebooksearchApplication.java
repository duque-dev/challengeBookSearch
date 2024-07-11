package com.alurapractice.challengebooksearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengebooksearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengebooksearchApplication.class, args);

		ShowMenu showMenu = new ShowMenu();
		showMenu.getshowMenu();
	}
}
