package com.wpruszak.crawler.model.primary.repository;

import com.wpruszak.crawler.model.primary.entity.SellerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
public interface SellerProfileRepository extends JpaRepository<SellerProfile, Long> {
}
