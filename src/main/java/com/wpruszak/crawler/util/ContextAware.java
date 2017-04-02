package com.wpruszak.crawler.util;

import org.springframework.context.ApplicationContext;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 01.04.17.
 */
public interface ContextAware {

    void setContext(ApplicationContext applicationContext);
}
