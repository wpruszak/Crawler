package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
public interface PageRepository extends JpaRepository<Page, Long> {
}
