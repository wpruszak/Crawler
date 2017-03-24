package com.wpruszak.crawler.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 24.03.17.
 */
@Configuration
@PropertySource("classpath:crawler.properties")
public class CrawlerConfiguration {
}
