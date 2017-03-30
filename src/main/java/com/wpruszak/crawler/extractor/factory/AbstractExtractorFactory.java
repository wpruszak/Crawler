package com.wpruszak.crawler.extractor.factory;

import com.wpruszak.crawler.extractor.ExtractorInterface;
import com.wpruszak.crawler.util.FactoryInterface;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
@Service
public abstract class AbstractExtractorFactory implements FactoryInterface<ExtractorInterface> {

    protected final Class eClass;

    protected final ApplicationContext applicationContext;

    public AbstractExtractorFactory(final Class eClass, final ApplicationContext applicationContext) {

        this.eClass = eClass;
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public ExtractorInterface create() {
        Object object = this.applicationContext.getBean(this.eClass.getClass());
        return ((ExtractorInterface) object);
    }
}
