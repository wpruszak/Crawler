package com.wpruszak.crawler.net.fetcher;

import com.wpruszak.crawler.net.http.RequestInterface;
import com.wpruszak.crawler.net.http.ResponseInterface;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 *
 * @param <RQ> Request class.
 */
@FunctionalInterface
public interface ToResponseFunction<RQ extends RequestInterface> {

    /**
     * Executes request and returns response.
     *
     * @param request request to transform (execute)
     * @param <RS>    response
     * @return executed requests response.
     */
    <RS extends ResponseInterface> RS applyAsResponse(RQ request);
}
