package com.wpruszak.crawler.model.primary.entity;

import com.wpruszak.crawler.util.Copyable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
@Entity
@Table(
    name = "categoryGroup",
    indexes = {@Index(name = "categoryGroupIdxName", columnList = "name")}
)
public class CategoryGroup implements Serializable, Copyable<CategoryGroup> {

    private static final long serialVersionUID = 7386971189809228793L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 200, unique = true, nullable = false)
    private String name;

    @OneToMany(
        mappedBy = "categoryGroup",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = {CascadeType.ALL},
        targetEntity = Category.class
    )
    private Set<Category> categories;

    public CategoryGroup() {
        this.categories = new TreeSet<>();
    }

    public CategoryGroup(final String name) {
        this();
        this.name = name;
    }

    public CategoryGroup(final String name, final Set<Category> categories) {
        this(name);
        this.categories = categories;
    }

    @Override
    public void copyFrom(final CategoryGroup entityToCopyFrom) {
        this.name = entityToCopyFrom.getName();
        this.categories = entityToCopyFrom.getCategories();
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

    public void removeCategory(final Category category) {
        this.categories.remove(category);
    }

    public void addCategory(final Category category) {
        this.categories.add(category);
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(final Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final CategoryGroup that = (CategoryGroup) o;

        if (this.id != that.id) {
            return false;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        return this.categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        int result = (int) (this.id ^ (this.id >>> 32));
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
