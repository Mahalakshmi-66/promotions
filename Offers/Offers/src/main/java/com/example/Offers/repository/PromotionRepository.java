package com.example.promotionservice.repository;

import com.example.promotionservice.domain.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // Search by title or category contains (case-insensitive)
    Page<Promotion> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String title, String category, Pageable pageable
    );
}
