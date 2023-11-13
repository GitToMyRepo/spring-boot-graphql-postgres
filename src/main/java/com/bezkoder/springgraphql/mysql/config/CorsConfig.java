package com.bezkoder.springgraphql.mysql.config;

import com.bezkoder.springgraphql.mysql.resolver.TutorialResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class CorsConfig {
    private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);
    @Bean
    public CorsFilter corsFilter() {
        logger.info("Entering corsFilter");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080");  // Update this with your actual allowed origin, e.g., "http://localhost:8080"
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/apis/graphql", config);  // Replace with your GraphQL endpoint mapping
        logger.info("Returning CorsFilter for " + source);
        return new CorsFilter(source);
    }
}
