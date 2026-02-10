package com.example.offerservice.service.impl;

import com.example.offerservice.api.dto.*;
import com.example.offerservice.api.mapper.OfferMapper;
import com.example.offerservice.domain.Offer;
import com.example.offerservice.repository.OfferRepository;
import com.example.offerservice.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repo;

    public OfferServiceImpl(OfferRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OfferResponse> list(String q, Pageable pageable) {
        Page<Offer> page = (q == null || q.isBlank())
                ? repo.findAll(pageable)
                : repo.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(q, q, pageable);

        return page.map(OfferMapper::toResponse);
    }

    @Override
    public OfferResponse getById(Long id) {
        Offer offer = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Offer not found: " + id));
        return OfferMapper.toResponse(offer);
    }

    @Override
    public OfferResponse create(OfferRequest req) {
        Offer saved = repo.save(OfferMapper.toEntity(req));
        return OfferMapper.toResponse(saved);
    }

    @Override
    public OfferResponse update(Long id, OfferRequest req) {
        Offer existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Offer not found: " + id));
        OfferMapper.updateEntity(existing, req);
        return OfferMapper.toResponse(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Offer not found: " + id);
        }
        repo.deleteById(id);
    }
}