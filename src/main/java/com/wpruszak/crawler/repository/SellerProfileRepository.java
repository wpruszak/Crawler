package com.wpruszak.crawler.repository;

import com.wpruszak.crawler.entity.SellerProfile;
import org.springframework.data.repository.CrudRepository;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 22.03.17.
 */
public interface SellerProfileRepository extends CrudRepository<SellerProfile, Long> {
}
