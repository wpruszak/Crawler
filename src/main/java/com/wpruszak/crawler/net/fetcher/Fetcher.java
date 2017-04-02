package com.wpruszak.crawler.net.fetcher;

import com.wpruszak.crawler.net.http.RequestInterface;
import com.wpruszak.crawler.net.http.ResponseInterface;

import java.util.function.Function;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 *
 * @param <RQ> Request class.
 * @param <RS> Response class.
 */
@FunctionalInterface
public interface Fetcher<RQ extends RequestInterface, RS extends ResponseInterface> {

    RS execute(final Function<RQ, RS> transformer, final RQ request);
}
