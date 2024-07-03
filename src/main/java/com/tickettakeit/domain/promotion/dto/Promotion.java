package com.tickettakeit.domain.promotion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Promotion {
    private Integer id;
    private Integer productId;
    private Integer fileId;
    private String productImageUrl;
}
