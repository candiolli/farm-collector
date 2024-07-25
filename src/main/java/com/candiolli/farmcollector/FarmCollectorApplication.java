package com.candiolli.farmcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class FarmCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmCollectorApplication.class, args);
	}

}
