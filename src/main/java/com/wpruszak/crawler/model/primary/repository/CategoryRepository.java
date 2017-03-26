package com.wpruszak.crawler.model.primary.repository;

import com.wpruszak.crawler.model.primary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
