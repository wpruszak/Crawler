package com.wpruszak.crawler.entity;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
public enum PageType {

    CATEGORY(0, "Category"),
    TOPSELLER_LIST(1, "Topseller list"),
    SELLER_LIST(2, "Seller list"),
    TOPSELLER_PROFILE(3, "Topseller profile"),
    SELLER_PROFILE(4, "Seller profile");

    private final int id;

    private final String name;

    private PageType(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
