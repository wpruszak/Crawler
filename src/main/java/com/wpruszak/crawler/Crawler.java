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
public class Crawler implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);

    public void run(String ...args) throws Exception {
        logger.info(String.format(
                "%s %s with arguments: %s",
                "Running",
                Crawler.class.toString(),
                Arrays.toString(args)
        ));
    }
}
