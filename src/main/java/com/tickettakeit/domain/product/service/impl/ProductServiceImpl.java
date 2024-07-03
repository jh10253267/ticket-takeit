package com.tickettakeit.domain.product.service.impl;

import com.tickettakeit.domain.product.dao.ProductDAO;
import com.tickettakeit.domain.product.dto.ProductResponse;
import com.tickettakeit.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductResponse getProductInfo(int start) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setItems(productDAO.selectDisplayInfo(start));
        productResponse.setTotalCount(productDAO.selectProductCount());

        return productResponse;
    }
    public ProductResponse getProductInfoByCategoryId(int categoryId, int cursor, int size) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setItems(productDAO.selectDisplayInfoByCategoryId(categoryId, cursor, size));
        productResponse.setTotalCount(productDAO.selectProductCountByCategoryId(categoryId));

        return productResponse;
    }
}
