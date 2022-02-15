package com.zmpa.eggstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EggstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EggstoreApplication.class, args);
	}

}
