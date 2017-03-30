package com.wpruszak.crawler.extractor;

import com.wpruszak.crawler.util.Copyable;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 */
public abstract class AbstractExtractor<E extends Copyable<E>> implements ExtractorInterface<E> {

    protected ExtractingStrategyInterface<E> extractingStrategy;

    public E extract(String body) {
        return this.extractingStrategy.extract(body);
    }
}
