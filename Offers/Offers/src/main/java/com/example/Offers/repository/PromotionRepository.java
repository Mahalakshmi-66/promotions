package com.example.Offers.repository;

import com.example.Offers.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // Search by title or category contains (case-insensitive)
    List<Promotion> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String title, String category
    );
}
