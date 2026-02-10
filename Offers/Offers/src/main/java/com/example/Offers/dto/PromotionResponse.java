package com.example.Offers.dto;

public record PromotionResponse(
        Long id,
        String title,
        String category,
        Integer costPoints
) {}
