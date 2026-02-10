package com.example.Offers.service;

import com.example.Offers.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferService {
    Page<OfferResponse> list(String q, Pageable pageable);
    OfferResponse getById(Long id);
    OfferResponse create(OfferRequest request);
    OfferResponse update(Long id, OfferRequest request);
    void delete(Long id);
}
