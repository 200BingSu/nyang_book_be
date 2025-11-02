package com.nyangbook.nyangbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

	public static void main(String[] args) {

		LOGGER.info("##### Application start ######");
		SpringApplication.run(Application.class, args);
		LOGGER.info("##### Application end ######");
	}

}
