package com.wpruszak.crawler.extractor;

import java.util.List;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 */
public interface Extractor<T> {

    List<T> extract(final String body);
}
