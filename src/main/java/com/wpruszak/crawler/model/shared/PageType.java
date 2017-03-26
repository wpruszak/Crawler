package com.wpruszak.crawler.model.shared;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
public enum PageType {

    CATEGORY(0),
    TOPSELLER_LIST(1),
    SELLER_LIST(2),
    TOPSELLER_PROFILE(3),
    SELLER_PROFILE(4);

    private final int id;

    public static PageType getById(Long id) {
        PageType.values();
        for (PageType pageType : PageType.values()) {
            if (pageType.getId() == id) {
                return pageType;
            }
        }
        return null;
    }

    private PageType(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return this.name();
    }
}
