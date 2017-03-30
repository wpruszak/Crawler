package com.wpruszak.crawler.extractor;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
public interface ExtractingStrategyInterface<E> {

    E extract(final String body);
}
