package com.tickettakeit.domain.promotion.service.impl;

import com.tickettakeit.domain.promotion.dao.PromotionDAO;
import com.tickettakeit.domain.promotion.dto.PromotionResponse;
import com.tickettakeit.domain.promotion.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {
    private final PromotionDAO dao;

    public PromotionResponse getAllPromotions() {
        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setItems(dao.selectAllPromotion());
        return promotionResponse;
    }
}
