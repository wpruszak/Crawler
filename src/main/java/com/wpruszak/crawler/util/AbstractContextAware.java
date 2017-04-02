package com.wpruszak.crawler.util;

import org.springframework.context.ApplicationContext;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 01.04.17.
 */
public abstract class AbstractContextAware implements ContextAware {

    protected ApplicationContext applicationContext;

    public AbstractContextAware(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
