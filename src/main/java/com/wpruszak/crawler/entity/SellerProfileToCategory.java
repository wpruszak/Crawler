package com.wpruszak.crawler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
@Entity
@Table(name = "sellerProfileToCategory")
public class SellerProfileToCategory {

    @ManyToOne(optional = false)
    @JoinColumn(name = "sellerProfileId", nullable = false)
    private SellerProfile sellerProfile;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @Column(name = "commentCount", nullable = false)
    private Integer commentCount;

    @Column(name = "isTopseller", nullable = false)
    private Boolean isTopseller;

    public SellerProfileToCategory() {
    }

    public SellerProfileToCategory(
        final SellerProfile sellerProfile,
        final Category category,
        final Integer commentCount,
        final Boolean isTopseller
    ) {
        this();
        this.sellerProfile = sellerProfile;
        this.category = category;
        this.commentCount = commentCount;
        this.isTopseller = isTopseller;
    }

    public SellerProfile getSellerProfile() {
        return this.sellerProfile;
    }

    public void setSellerProfile(final SellerProfile sellerProfile) {
        this.sellerProfile = sellerProfile;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(final Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getTopseller() {
        return this.isTopseller;
    }

    public void setTopseller(final Boolean topseller) {
        this.isTopseller = topseller;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final SellerProfileToCategory that = (SellerProfileToCategory) o;

        if (!this.sellerProfile.equals(that.sellerProfile)) {
            return false;
        }
        if (!this.category.equals(that.category)) {
            return false;
        }
        if (!this.commentCount.equals(that.commentCount)) {
            return false;
        }
        return this.isTopseller.equals(that.isTopseller);
    }

    @Override
    public int hashCode() {
        int result = this.sellerProfile.hashCode();
        result = 31 * result + this.category.hashCode();
        result = 31 * result + this.commentCount.hashCode();
        result = 31 * result + this.isTopseller.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
            .append(this.sellerProfile.getMerchantId())
            .append(" : ")
            .append(this.category.getNodeId())
            .toString();
    }
}
