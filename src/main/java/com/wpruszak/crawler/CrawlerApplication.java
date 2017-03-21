package com.wpruszak.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@SpringBootApplication
public class CrawlerApplication {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(CrawlerApplication.class, args);
        logger.info("Stopping application...");
    }
}
