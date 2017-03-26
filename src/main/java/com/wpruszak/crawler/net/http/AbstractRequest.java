package com.wpruszak.crawler.net.http;

import java.io.Serializable;
import java.util.Map;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 27.03.17.
 */
public abstract class AbstractRequest implements RequestInterface, Serializable {

    private static final long serialVersionUID = -2872762139468923025L;

    protected Protocol protocol;
    protected String path;
    protected String host;
    protected Long epochSeconds;
    protected Map<String, String> parameters;
    protected Method method;
    protected ResponseInterface response;
    protected Map<String, String> headers;
    protected Map<String, String> cookies;

    @Override
    public Protocol getProtocol() {
        return this.protocol;
    }

    @Override
    public void setProtocol(final Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(final String path) {
        this.path = path;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public void setHost(final String host) {
        this.host = host;
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
    public Map<String, String> getParameters() {
        return this.parameters;
    }

    @Override
    public void setParameters(final Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void addParameter(final String key, final String value) {
        this.parameters.put(key, value);
    }

    @Override
    public void removeParameter(final String key) {
        this.parameters.remove(key);
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(final Method method) {
        this.method = method;
    }

    @Override
    public ResponseInterface getResponse() {
        return this.response;
    }

    @Override
    public void setResponse(final ResponseInterface response) {
        this.response = response;
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
