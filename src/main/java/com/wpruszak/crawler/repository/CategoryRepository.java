package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 21.03.17.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
