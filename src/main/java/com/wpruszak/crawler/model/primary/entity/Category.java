package com.wpruszak.crawler.model.primary.entity;

import com.wpruszak.crawler.util.Copyable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Entity
@Table(
    name = "category",
    indexes = {
        @Index(name = "categoryIdxNodeId", columnList = "nodeId"),
        @Index(name = "categoryIdxCategoryGroupId", columnList = "categoryGroupId")
    }
)
public class Category implements Serializable, Copyable<Category> {

    private static final long serialVersionUID = 5126072244138756276L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 200, unique = true, nullable = false)
    private String name;

    @Column(name = "nodeId", length = 200, unique = true, nullable = false)
    private String nodeId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = CategoryGroup.class)
    @JoinColumn(name = "categoryGroupId", nullable = false)
    private CategoryGroup categoryGroup;

    @OneToMany(mappedBy = "category")
    private Set<SellerProfileToCategory> sellerProfilesToCategory;

    public Category() {
        this.sellerProfilesToCategory = new HashSet<>();
    }

    public Category(final String name, final String nodeId) {
        this();
        this.name = name;
        this.nodeId = nodeId;
    }

    public Category(final String name, final String nodeId, final CategoryGroup categoryGroup) {
        this(name, nodeId);
        this.categoryGroup = categoryGroup;
    }

    public Category(
        final String name,
        final String nodeId,
        final CategoryGroup categoryGroup,
        final Set<SellerProfileToCategory> sellerProfileToCategories) {

        this(name, nodeId, categoryGroup);
        this.sellerProfilesToCategory = sellerProfileToCategories;
    }

    @Override
    public void copyFrom(final Category entityToCopyFrom) {
        this.nodeId = entityToCopyFrom.getNodeId();
        this.name = entityToCopyFrom.getName();
        this.categoryGroup = entityToCopyFrom.getCategoryGroup();
        this.sellerProfilesToCategory = entityToCopyFrom.getSellerProfilesToCategory();
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

    public String getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(final String nodeId) {
        this.nodeId = nodeId;
    }

    public CategoryGroup getCategoryGroup() {
        return this.categoryGroup;
    }

    public void setCategoryGroup(final CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public void addSellerProfileToCategory(final SellerProfileToCategory sellerProfileToCategory) {
        this.sellerProfilesToCategory.add(sellerProfileToCategory);
    }

    public void removeSellerProfileToCategory(final SellerProfileToCategory sellerProfileToCategory) {
        this.sellerProfilesToCategory.remove(sellerProfileToCategory);
    }

    public Set<SellerProfileToCategory> getSellerProfilesToCategory() {
        return this.sellerProfilesToCategory;
    }

    public void setSellerProfilesToCategory(final Set<SellerProfileToCategory> sellerProfilesToCategory) {
        this.sellerProfilesToCategory = sellerProfilesToCategory;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Category that = (Category) o;

        return this.nodeId.equals(that.nodeId);
    }

    @Override
    public int hashCode() {
        return this.nodeId.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
