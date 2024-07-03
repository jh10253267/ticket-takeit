package com.tickettakeit.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    Integer displayInfoId;
    Integer productId;
    Integer fileId;
    String productDescription;
    String placeName;
    String productContent;
    String productImageUrl;
}
