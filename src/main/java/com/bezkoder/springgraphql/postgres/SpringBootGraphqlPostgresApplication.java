package com.bezkoder.springgraphql.postgres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGraphqlPostgresApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootGraphqlPostgresApplication.class);

	public static void main(String[] args) {
		logger.info("Starting up SpringBootGraphqlMysqlApplication");
		SpringApplication.run(SpringBootGraphqlPostgresApplication.class, args);
	}

	@Bean
	public graphql.schema.GraphQLScalarType extendedScalarLong() {
		logger.info("Returning GraphQLLong");
	    return graphql.scalars.ExtendedScalars.GraphQLLong;
	}
}
