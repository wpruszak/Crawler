package com.wpruszak.crawler.util;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
public interface Copyable<E> {

    void copyFrom(final E entityToCopyFrom);
}
