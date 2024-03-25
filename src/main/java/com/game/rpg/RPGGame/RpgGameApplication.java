package com.game.rpg.RPGGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.game.rpg")
public class RpgGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgGameApplication.class, args);
	}

}
