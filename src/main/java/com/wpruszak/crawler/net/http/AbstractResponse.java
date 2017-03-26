package com.wpruszak.crawler.net.http;

import java.io.Serializable;
import java.util.Map;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 27.03.17.
 */
public abstract class AbstractResponse implements ResponseInterface, Serializable {

    private static final long serialVersionUID = -716779564945371990L;

    protected StatusCode statusCode;
    protected Long epochSeconds;
    protected String body;
    protected String contentType;
    protected String charset;
    protected Integer redirectCount;
    protected Boolean isCaptcha;
    protected RequestInterface request;
    protected Map<String, String> headers;
    protected Map<String, String> cookies;

    @Override
    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    @Override
    public void setStatusCode(final StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Long getEpochSeconds() {
        return this.epochSeconds;
    }

    @Override
    public void setEpochSeconds(final Long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    @Override
    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getCharset() {
        return this.charset;
    }

    @Override
    public void setCharset(final String charset) {
        this.charset = charset;
    }

    @Override
    public Integer getRedirectCount() {
        return this.redirectCount;
    }

    @Override
    public void setRedirectCount(final Integer redirectCount) {
        this.redirectCount = redirectCount;
    }

    @Override
    public Boolean getIsCaptcha() {
        return this.isCaptcha;
    }

    @Override
    public void setIsCaptcha(final Boolean captcha) {
        this.isCaptcha = captcha;
    }

    @Override
    public RequestInterface getRequest() {
        return this.request;
    }

    @Override
    public void setRequest(final RequestInterface request) {
        this.request = request;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public void setHeaders(final Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public void addHeader(final String key, final String value) {
        this.headers.put(key, value);
    }

    @Override
    public void removeHeader(final String key) {
        this.headers.remove(key);
    }

    @Override
    public Map<String, String> getCookies() {
        return this.cookies;
    }

    @Override
    public void setCookies(final Map<String, String> cookies) {
        this.cookies = cookies;
    }

    @Override
    public void addCookie(final String key, final String value) {
        this.cookies.put(key, value);
    }

    @Override
    public void removeCookie(final String key) {
        this.cookies.remove(key);
    }
}
