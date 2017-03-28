package com.wpruszak.crawler.net.fetcher;

import com.wpruszak.crawler.net.http.RequestInterface;
import com.wpruszak.crawler.net.http.ResponseInterface;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 */
@FunctionalInterface
public interface ToResponseFunction<RQ extends RequestInterface> {

    <RS extends ResponseInterface> RS applyAsResponse(RQ request);
}
