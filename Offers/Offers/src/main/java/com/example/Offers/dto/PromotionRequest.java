package com.example.Offers.dto;

import jakarta.validation.constraints.*;

public record PromotionRequest(
        @NotBlank String title,
        @NotBlank String category,
        @NotNull @Min(0) Integer costPoints
) {}
