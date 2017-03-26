package com.wpruszak.crawler.net.http;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
public enum Protocol {
    HTTP(0), HTTPS(1);

    private final int id;

    public static Protocol getById(int id) {
        Protocol.values();
        for (Protocol protocol : Protocol.values()) {
            if (protocol.getId() == id) {
                return protocol;
            }
        }
        return null;
    }

    private Protocol(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
