package com.wpruszak.crawler.extractor.factory;

import com.wpruszak.crawler.extractor.ExtractingStrategyInterface;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
@Service
public abstract class AbstractExtractingStrategyFactory implements ExtractingStrategyFactoryInterface {

    protected final ApplicationContext applicationContext;

    protected final Class eClass;

    public AbstractExtractingStrategyFactory(final Class eClass, final ApplicationContext applicationContext) {
        this.eClass = eClass;
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public ExtractingStrategyInterface create() {
        Object object = this.applicationContext.getBean(this.eClass.getClass());
        return ((ExtractingStrategyInterface)object);
    }
}
