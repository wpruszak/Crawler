package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Long> {
}
