package com.tickettakeit.domain.product.controller;

import com.tickettakeit.domain.product.dto.ProductResponse;
import com.tickettakeit.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public ProductResponse getProducts(@RequestParam(required = false) Integer categoryId,
                                       @RequestParam(required = false, defaultValue = "0") int cursor,
                                       @RequestParam(required = false, defaultValue = "4") int size) {
        if(categoryId == null) {
            return productService.getProductInfo(1);
        } else {
            return productService.getProductInfoByCategoryId(categoryId, cursor, size);
        }
    }
}
