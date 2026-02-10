package com.example.Offers.repository;

import com.example.Offers.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    Page<Offer> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String title, String category, Pageable pageable
    );
}