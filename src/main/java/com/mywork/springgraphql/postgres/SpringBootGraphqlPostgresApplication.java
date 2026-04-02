package com.mywork.springgraphql.postgres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGraphqlPostgresApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootGraphqlPostgresApplication.class);

	public static void main(String[] args) {
		logger.info("Starting up SpringBootGraphqlPostgresApplication");
		SpringApplication.run(SpringBootGraphqlPostgresApplication.class, args);
	}
}
