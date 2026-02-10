package com.example.Offers.service.impl;

import com.example.Offers.dto.PromotionRequest;
import com.example.Offers.dto.PromotionResponse;
import com.example.Offers.mapper.PromotionMapper;
import com.example.Offers.entity.Promotion;
import com.example.Offers.repository.PromotionRepository;
import com.example.Offers.service.PromotionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository repository;

    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PromotionResponse> list(String q, Pageable pageable) {
        Page<Promotion> page = (q == null || q.isBlank())
                ? repository.findAll(pageable)
                : repository.findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(q, q, pageable);

        return page.map(PromotionMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public PromotionResponse getById(Long id) {
        Promotion p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Promotion not found: " + id));
        return PromotionMapper.toResponse(p);
    }

    @Override
    public PromotionResponse create(PromotionRequest request) {
        Promotion saved = repository.save(PromotionMapper.toEntity(request));
        return PromotionMapper.toResponse(saved);
    }

    @Override
    public PromotionResponse update(Long id, PromotionRequest request) {
        Promotion existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Promotion not found: " + id));
        PromotionMapper.updateEntity(existing, request);
        return PromotionMapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Promotion not found: " + id);
        }
        repository.deleteById(id);
    }
}