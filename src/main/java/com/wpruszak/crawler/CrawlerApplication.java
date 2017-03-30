package com.wpruszak.crawler;

import com.wpruszak.crawler.configuration.CrawlerApplicationContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@EnableAutoConfiguration
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class CrawlerApplication {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerApplication.class);

    public static void main(String[] args) {

        CrawlerApplication.logger.info("Starting application...");
        new SpringApplicationBuilder(CrawlerApplication.class)
            .initializers(new CrawlerApplicationContextInitializer())
            .run(args);
        CrawlerApplication.logger.info("Stopping application...");
    }
}
