package com.wpruszak.crawler.extractor.factory;

import com.wpruszak.crawler.extractor.Extractor;
import com.wpruszak.crawler.util.AbstractContextAware;
import org.springframework.context.ApplicationContext;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
public abstract class AbstractExtractorFactory extends AbstractContextAware implements ExtractorFactory {

    public AbstractExtractorFactory(final ApplicationContext applicationContext) {
        super(applicationContext);
    }

    public Extractor create(Class clazz) {
        // TODO
        return null;
    }
}
