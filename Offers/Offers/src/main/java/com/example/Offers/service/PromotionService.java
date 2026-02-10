package com.example.Offers.service;

import com.example.Offers.dto.PromotionRequest;
import com.example.Offers.dto.PromotionResponse;
import java.util.List;

public interface PromotionService {
    List<PromotionResponse> list(String q);
    PromotionResponse getById(Long id);
    PromotionResponse create(PromotionRequest request);
    PromotionResponse update(Long id, PromotionRequest request);
    void delete(Long id);
}