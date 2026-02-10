package com.example.promotionservice.api.dto;

import jakarta.validation.constraints.*;

public record PromotionRequest(
        @NotBlank String title,
        @NotBlank String category,
        @NotNull @Min(0) Integer costPoints
) {}

public record PromotionResponse(
        Long id,
        String title,
        String category,
        Integer costPoints
) {}
