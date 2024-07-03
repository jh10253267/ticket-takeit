package com.tickettakeit.domain.promotion.controller;

import com.tickettakeit.domain.promotion.dto.PromotionResponse;
import com.tickettakeit.domain.promotion.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
@RequiredArgsConstructor
public class PromotionRestController {
    private final PromotionService promotionService;
    @GetMapping
    public PromotionResponse getPromotions() {
        return promotionService.getAllPromotions();
    }
}
