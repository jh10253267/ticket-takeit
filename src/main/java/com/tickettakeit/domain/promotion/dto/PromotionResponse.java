package com.tickettakeit.domain.promotion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PromotionResponse {
    private List<Promotion> items;
}
