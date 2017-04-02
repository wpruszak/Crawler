package com.wpruszak.crawler.net.http;

import java.util.Map;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
public interface ResponseInterface {

    default Boolean isCaptcha() {
        return this.getIsCaptcha();
    }

    Boolean getIsCaptcha();

    void setIsCaptcha(Boolean isCaptcha);

    StatusCode getStatusCode();

    void setStatusCode(StatusCode statusCode);

    Long getEpochSeconds();

    void setEpochSeconds(Long epochSeconds);

    String getBody();

    void setBody(String body);

    String getContentType();

    void setContentType(String contentType);

    String getCharset();

    void setCharset(String charset);

    Integer getRedirectCount();

    void setRedirectCount(Integer redirectCount);

    RequestInterface getRequest();

    void setRequest(RequestInterface request);

    Map<String, String> getHeaders();

    void setHeaders(Map<String, String> headers);

    void addHeader(String key, String value);

    void removeHeader(String key);

    Map<String, String> getCookies();

    void setCookies(Map<String, String> cookies);

    void addCookie(String key, String value);

    void removeCookie(String key);
}
