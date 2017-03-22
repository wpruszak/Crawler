package com.wpruszak.crawler.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Entity
@Table(
    name = "sellerProfile",
    indexes = {
        @Index(name = "sellerProfileIdxMerchantId", columnList = "merchantId"),
        @Index(name = "sellerProfileIdxName", columnList = "name")
    }
)
public class SellerProfile implements Serializable {

    private static final long serialVersionUID = -7102780515877439093L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "merchantId", length = 20, unique = true, nullable = false)
    private String merchantId;

    @Column(name = "percentileRating", nullable = false)
    private Integer percentileRating;

    @Column(name = "ratingCount", nullable = false)
    private Integer ratingCount;

    @Column(name = "phoneNumber", length = 100)
    private String phoneNumber;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "tradeRegisterNumber", length = 100)
    private String tradeRegisterNumber;

    @Column(name = "businessType", length = 100)
    private String businessType;

    @Lob
    @Column(name = "text")
    private String text;

    @ElementCollection
    private Map<Integer, Integer> commentsInCategory;

    @ManyToMany
    @JoinTable(
        name = "sellerProfileToCategory",
        joinColumns = @JoinColumn(name = "sellerProfileId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "id")
    )
    private Set<Category> categories;

    public SellerProfile() {
        this.commentsInCategory = new HashMap<>();
        this.categories = new HashSet<>();
    }

    public SellerProfile(
        final String name,
        final String description,
        final String merchantId,
        final Integer percentileRating,
        final Integer ratingCount,
        final String phoneNumber,
        final String address,
        final String tradeRegisterNumber,
        final String businessType,
        final String text
    ) {

        this();
        this.name = name;
        this.description = description;
        this.merchantId = merchantId;
        this.percentileRating = percentileRating;
        this.ratingCount = ratingCount;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.tradeRegisterNumber = tradeRegisterNumber;
        this.businessType = businessType;
        this.text = text;
    }

    public SellerProfile(
        final String name,
        final String description,
        final String merchantId,
        final Integer percentileRating,
        final Integer ratingCount,
        final String phoneNumber,
        final String address,
        final String tradeRegisterNumber,
        final String businessType,
        final String text,
        final Set<Category> categories,
        final Map<Integer, Integer> commentsInCategory
    ) {

        this(
            name,
            description,
            merchantId,
            percentileRating,
            ratingCount,
            phoneNumber,
            address,
            tradeRegisterNumber,
            businessType,
            text
        );
        this.categories = categories;
        this.commentsInCategory = commentsInCategory;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getPercentileRating() {
        return this.percentileRating;
    }

    public void setPercentileRating(final Integer percentileRating) {
        this.percentileRating = percentileRating;
    }

    public Integer getRatingCount() {
        return this.ratingCount;
    }

    public void setRatingCount(final Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getTradeRegisterNumber() {
        return this.tradeRegisterNumber;
    }

    public void setTradeRegisterNumber(final String tradeRegisterNumber) {
        this.tradeRegisterNumber = tradeRegisterNumber;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(final String businessType) {
        this.businessType = businessType;
    }

    public void removeCategory(final Category category) {
        if (this.categories.contains(category)) {
            this.categories.remove(category);
        }
    }

    public void addCategory(final Category category) {
        this.categories.add(category);
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(final Set<Category> categories) {
        this.categories = categories;
    }

    public Map<Integer, Integer> getCommentsInCategory() {
        return this.commentsInCategory;
    }

    public void setCommentsInCategory(final Map<Integer, Integer> commentsInCategory) {
        this.commentsInCategory = commentsInCategory;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final SellerProfile that = (SellerProfile) o;

        return this.merchantId.equals(that.merchantId);
    }

    @Override
    public int hashCode() {
        return this.merchantId.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
