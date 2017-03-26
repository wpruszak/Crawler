package com.wpruszak.crawler;

import com.wpruszak.crawler.manager.ExecutionManager;
import com.wpruszak.crawler.model.primary.entity.Page;
import com.wpruszak.crawler.model.primary.entity.PageType;
import com.wpruszak.crawler.model.primary.repository.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Component
public class CrawlerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerRunner.class);

    private ExecutionManager executionManager;

    private StringRedisTemplate redisTemplate;

    private PageRepository pageRepository;

    @Autowired
    public CrawlerRunner(
        ExecutionManager executionManager,
        @Qualifier("redisStringTemplate") StringRedisTemplate redisTemplate,
        PageRepository pageRepository
    ) {
        this.executionManager = executionManager;
        this.redisTemplate = redisTemplate;
        this.pageRepository = pageRepository;
    }

    public void run(String... args) throws Exception {

        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        String key = "test";
        System.out.println(this.redisTemplate.hasKey("test"));
        if (!this.redisTemplate.hasKey(key)) {
            ops.set(key, "test");
        }
        System.out.println(key + " : " + ops.get(key));

        Page page = new Page();
        page.setHtml("test");
        page.setType(PageType.CATEGORY);
        page.setUrl("test");
        this.pageRepository.saveAndFlush(page);

        logger.info(String.format(
            "%s %s with arguments: %s",
            "Running",
            CrawlerRunner.class.toString(),
            Arrays.toString(args)
        ));
    }
}
