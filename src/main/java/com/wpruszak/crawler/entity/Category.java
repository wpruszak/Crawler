package com.wpruszak.crawler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Entity
@Table(
    name = "category",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "nodeId"),
        @UniqueConstraint(columnNames = "categoryGroupId")
    }
)
public class Category implements Serializable {

    private static final long serialVersionUID = 5126072244138756276L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(name = "nodeId", length = 200, nullable = false)
    private String nodeId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryGroupId", nullable = false)
    private CategoryGroup categoryGroup;

    public Category() {
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


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Category category = (Category) o;

        if (this.id != category.id) {
            return false;
        }
        if (!this.name.equals(category.name)) {
            return false;
        }

        if (!this.nodeId.equals(category.nodeId)) {
            return false;
        }
        return this.categoryGroup.equals(category.categoryGroup);
    }

    @Override
    public int hashCode() {
        int result = (int) (this.id ^ (this.id >>> 32));
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.nodeId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name;
    }
}