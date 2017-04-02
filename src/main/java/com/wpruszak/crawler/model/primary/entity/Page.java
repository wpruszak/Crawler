package com.wpruszak.crawler.model.primary.entity;

import com.wpruszak.crawler.model.shared.PageType;
import com.wpruszak.crawler.util.Copyable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
@Entity
@Table(name = "page")
public class Page implements Serializable, Copyable<Page> {

    private static final long serialVersionUID = 6331648816241050063L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "url", nullable = false, length = 10000)
    private String url;

    @Lob
    @Column(name = "html")
    private String html;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PageType type;

    public Page() {
    }

    public Page(final String url, final String html, final PageType type) {
        this.url = url;
        this.html = html;
        this.type = type;
    }

    @Override
    public void copyFrom(final Page entityToCopyFrom) {
        this.url = entityToCopyFrom.getUrl();
        this.type = entityToCopyFrom.getType();
        this.html = entityToCopyFrom.getHtml();
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public PageType getType() {
        return this.type;
    }

    public String getHtml() {
        return this.html;
    }

    public void setHtml(final String html) {
        this.html = html;
    }

    public void setType(final PageType type) {
        this.type = type;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return this.url.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Page page = (Page) o;

        return this.url.equals(page.url);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.type.toString(), this.url);
    }
}
