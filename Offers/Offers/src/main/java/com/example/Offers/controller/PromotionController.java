package com.example.promotionservice.api;

import com.example.promotionservice.api.dto.PromotionRequest;
import com.example.promotionservice.api.dto.PromotionResponse;
import com.example.promotionservice.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }

    // GET /api/promotions?q=electronics&page=0&size=10&sort=title,asc
    @GetMapping
    public Page<PromotionResponse> list(
            @RequestParam(value = "q", required = false) String q,
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return service.list(q, pageable);
    }

    // GET /api/promotions/{id}
    @GetMapping("/{id}")
    public PromotionResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST /api/promotions
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromotionResponse create(@Valid @RequestBody PromotionRequest request) {
        return service.create(request);
    }

    // PUT /api/promotions/{id}
    @PutMapping("/{id}")
    public PromotionResponse update(@PathVariable Long id,
                                    @Valid @RequestBody PromotionRequest request) {
        return service.update(id, request);
    }

    // DELETE /api/promotions/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
``