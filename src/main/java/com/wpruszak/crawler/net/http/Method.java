package com.wpruszak.crawler.net.http;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
public enum Method {

    GET(0),
    POST(1),
    PUT(2),
    DELETE(3),
    HEAD(4),
    CONNECT(5),
    TRACE(6),
    OPTIONS(7),
    PATCH(8);

    private final int id;

    private Method(final int id) {
        this.id = id;
    }

    public static Method getById(int id) {
        Method.values();
        for (Method method : Method.values()) {
            if (method.getId() == id) {
                return method;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
