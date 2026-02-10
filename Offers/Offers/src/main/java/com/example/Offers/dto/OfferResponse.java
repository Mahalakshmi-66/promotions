package com.example.OfferService.api.dto;

import java.time.LocalDate;

public record OfferResponse(
        Long id,
        String title,
        String category,
        String description,
        Integer costPoints,
        LocalDate startDate,
        LocalDate endDate,
        String tierLevel,
        String imageUrl
) {}