package com.example.Offers.controller;

import com.example.Offers.dto.PromotionRequest;
import com.example.Offers.dto.PromotionResponse;
import com.example.Offers.service.PromotionService;
import jakarta.validation.Valid;
import java.util.List;
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
    public List<PromotionResponse> list(@RequestParam(value = "q", required = false) String q) {
        return service.list(q);
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
 