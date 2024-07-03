package com.tickettakeit.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    private List<Product> items;
    private int totalCount;
}
