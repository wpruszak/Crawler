package com.wpruszak.crawler.model.primary.repository;

import com.wpruszak.crawler.model.primary.entity.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Long> {
}
