package com.dhmo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dhmo.dao.RestRoomRepository;
import com.dhmo.model.RestRoom;

@SpringBootApplication
public class NaverCodingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(NaverCodingApplication.class);
	
	public static Iterable<RestRoom> it =null;
	
	public static void main(String[] args) {
		SpringApplication.run(NaverCodingApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(RestRoomRepository repository) {
		return (args) -> {
			// fetch all customers
			log.info("-------------------------------");
			it = repository.findAll();
			log.info("");

		};
	}
}
