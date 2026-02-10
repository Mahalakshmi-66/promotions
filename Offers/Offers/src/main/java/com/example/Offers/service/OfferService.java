package com.example.Offers.service;

import com.example.Offers.dto.*;
import java.util.List;

public interface OfferService {
    List<OfferResponse> list(String q);
    OfferResponse getById(Long id);
    OfferResponse create(OfferRequest request);
    OfferResponse update(Long id, OfferRequest request);
    void delete(Long id);
}
