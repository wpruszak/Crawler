package com.wpruszak.crawler;

import com.wpruszak.crawler.manager.ExecutionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Component
public class CrawlerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerRunner.class);

    private ExecutionManager executionManager;

    @Autowired
    public CrawlerRunner(ExecutionManager executionManager) {
        this.executionManager = executionManager;
    }

    public void run(String... args) throws Exception {

        logger.info(String.format(
            "%s %s with arguments: %s",
            "Running",
            CrawlerRunner.class.toString(),
            Arrays.toString(args)
        ));
    }
}
