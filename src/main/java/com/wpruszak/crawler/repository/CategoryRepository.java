package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
