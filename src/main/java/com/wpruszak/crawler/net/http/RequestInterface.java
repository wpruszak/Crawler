package com.wpruszak.crawler.net.http;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
public interface RequestInterface {

    default String getUrl() {
        return new StringBuilder()
            .append(this.getProtocol().toString())
            .append("://")
            .append(this.getHost())
            .append(this.getPath())
            .append("?")
            .append(this.getQuery())
            .toString();
    }

    Protocol getProtocol();

    void setProtocol(Protocol protocol);

    String getHost();

    String getPath();

    default String getQuery() {
        return this.getParameters()
            .entrySet()
            .stream()
            .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining());
    }

    Map<String, String> getParameters();

    void setParameters(Map<String, String> parameters);

    void setPath(String path);

    void setHost(String host);

    Long getEpochSeconds();

    void setEpochSeconds(Long epochSeconds);

    void addParameter(String key, String value);

    void removeParameter(String key);

    Method getMethod();

    void setMethod(Method method);

    ResponseInterface getResponse();

    void setResponse(ResponseInterface response);

    Map<String, String> getHeaders();

    void setHeaders(Map<String, String> headers);

    void addHeader(String key, String value);

    void removeHeader(String key);

    Map<String, String> getCookies();

    void setCookies(Map<String, String> cookies);

    void addCookie(String key, String value);

    void removeCookie(String key);
}
