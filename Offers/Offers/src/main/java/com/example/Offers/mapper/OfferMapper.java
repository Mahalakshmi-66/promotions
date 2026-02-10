package com.example.offerservice.api.mapper;

import com.example.offerservice.api.dto.*;
import com.example.offerservice.domain.Offer;

public class OfferMapper {

    public static Offer toEntity(OfferRequest req) {
        return new Offer(
                null,
                req.title(),
                req.category(),
                req.description(),
                req.costPoints(),
                req.startDate(),
                req.endDate(),
                req.tierLevel(),
                req.imageUrl()
        );
    }

    public static OfferResponse toResponse(Offer offer) {
        return new OfferResponse(
                offer.getId(),
                offer.getTitle(),
                offer.getCategory(),
                offer.getDescription(),
                offer.getCostPoints(),
                offer.getStartDate(),
                offer.getEndDate(),
                offer.getTierLevel(),
                offer.getImageUrl()
        );
    }

    public static void updateEntity(Offer offer, OfferRequest req) {
        offer.setTitle(req.title());
        offer.setCategory(req.category());
        offer.setDescription(req.description());
        offer.setCostPoints(req.costPoints());
        offer.setStartDate(req.startDate());
        offer.setEndDate(req.endDate());
        offer.setTierLevel(req.tierLevel());
        offer.setImageUrl(req.imageUrl());
    }
}