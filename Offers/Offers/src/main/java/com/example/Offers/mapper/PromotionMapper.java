package com.example.Offers.mapper;

import com.example.Offers.dto.*;
import com.example.Offers.entity.Promotion;

public final class PromotionMapper {
    private PromotionMapper() {}
    public static Promotion toEntity(PromotionRequest req) {
        return new Promotion(null, req.title(), req.category(), req.costPoints());
    }
    public static PromotionResponse toResponse(Promotion entity) {
        return new PromotionResponse(entity.getId(), entity.getTitle(),
                entity.getCategory(), entity.getCostPoints());
    }
    public static void updateEntity(Promotion entity, PromotionRequest req) {
        entity.setTitle(req.title());
        entity.setCategory(req.category());
        entity.setCostPoints(req.costPoints());
    }
}