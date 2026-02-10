package com.example.Offers.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record OfferRequest(
        @NotBlank String title,
        @NotBlank String category,
        @NotBlank String description,
        @NotNull @Min(0) Integer costPoints,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotBlank String tierLevel,
        String imageUrl
) {}