package com.droy.tubedepartureboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TubeDepartureBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TubeDepartureBoardApplication.class, args);
	}

}
