package com.wpruszak.crawler.extractor;

import com.wpruszak.crawler.util.Copyable;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 */
public interface ExtractorInterface<E extends Copyable<E>> {

    default  E extractAndUpdate(final String body, final E entity) {
        E entityToCopyFrom = this.extract(body);
        entity.copyFrom(entityToCopyFrom);
        return entity;
    }

    E extract(final String body);
}
