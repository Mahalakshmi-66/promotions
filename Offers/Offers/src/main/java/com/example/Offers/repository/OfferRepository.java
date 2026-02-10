package com.example.Offers.repository;

import com.example.Offers.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String title, String category
    );
}