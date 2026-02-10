package com.example.promotionservice.service;

import com.example.promotionservice.api.dto.PromotionRequest;
import com.example.promotionservice.api.dto.PromotionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromotionService {
    Page<PromotionResponse> list(String q, Pageable pageable);
    PromotionResponse getById(Long id);
    PromotionResponse create(PromotionRequest request);
    PromotionResponse update(Long id, PromotionRequest request);
    void delete(Long id);
}