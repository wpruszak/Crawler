package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.SellerProfileToCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 24.03.17.
 */
public interface SellerProfileToCategoryRepository extends JpaRepository<SellerProfileToCategory, Long> {
}
