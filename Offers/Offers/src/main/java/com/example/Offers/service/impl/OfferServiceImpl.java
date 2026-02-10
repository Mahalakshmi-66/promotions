package com.example.Offers.service.impl;

import com.example.Offers.dto.*;
import com.example.Offers.mapper.OfferMapper;
import com.example.Offers.entity.Offer;
import com.example.Offers.repository.OfferRepository;
import com.example.Offers.service.OfferService;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<OfferResponse> list(String q) {
        List<Offer> list = (q == null || q.isBlank())
                ? repo.findAll()
                : repo.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(q, q);

        return list.stream().map(OfferMapper::toResponse).collect(Collectors.toList());
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