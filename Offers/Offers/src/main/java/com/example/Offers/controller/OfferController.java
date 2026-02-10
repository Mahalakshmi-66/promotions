package com.example.OfferService.api;

import com.example.offerservice.api.dto.*;
import com.example.offerservice.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService service;

    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping
    public Page<OfferResponse> list(
            @RequestParam(required = false) String q,
            @PageableDefault(size = 10) Pageable pageable) {
        return service.list(q, pageable);
    }

   id}")
    public OfferResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfferResponse create(@Valid @RequestBody OfferRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public OfferResponse update(@PathVariable Long id,
                                @Valid @RequestBody OfferRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}