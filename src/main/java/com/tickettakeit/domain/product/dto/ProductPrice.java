package com.tickettakeit.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductPrice {
    private int productPriceId;
    private int productId;
    private String priceTypeName;
    private int price;
    private String createDate;
    private String modifyDate;
    private BigDecimal discountRate;
}
