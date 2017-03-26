package com.wpruszak.crawler;

import com.wpruszak.crawler.net.fetcher.Fetcher;
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

    private Fetcher fetcher;

    @Autowired
    public CrawlerRunner(Fetcher fetcher) {
        this.fetcher = fetcher;
    }

    public void run(String... args) throws Exception {

        this.fetcher.fetchPage("http://www.whoishostingthis.com/tools/user-agent/?test=test&test2=test2");

        logger.info(String.format(
            "%s %s with arguments: %s",
            "Running",
            CrawlerRunner.class.toString(),
            Arrays.toString(args)
        ));
    }
}
