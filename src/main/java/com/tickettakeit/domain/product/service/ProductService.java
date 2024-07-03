package com.tickettakeit.domain.product.service;

import com.tickettakeit.domain.product.dto.ProductResponse;

public interface ProductService {
    ProductResponse getProductInfo(int start);
    ProductResponse getProductInfoByCategoryId(int categoryId, int cursor, int size);
}
