package com.wpruszak.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Component
public class CrawlerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerRunner.class);

    public void run(String... args) {

        logger.info(String.format(
            "%s %s with arguments: %s",
            "Running",
            CrawlerRunner.class.toString(),
            Arrays.toString(args)
        ));
    }
}
