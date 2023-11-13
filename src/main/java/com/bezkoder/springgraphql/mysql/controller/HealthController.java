package com.bezkoder.springgraphql.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class HealthController {
    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/health")
    public String healthCheck() {
        logger.info("checking Spring Boot Web Service status");
        return "Spring Boot Web Service is running";
    }
}
