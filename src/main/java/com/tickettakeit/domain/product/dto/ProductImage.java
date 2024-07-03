package com.tickettakeit.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductImage {
    private String contentType;
    private String createDate;
    private boolean deleteFlag;
    private Integer fileInfoId;
    private String fileName;
    private String modifyDate;
    private Integer productId;
    private Integer productImageId;
    private String saveFileName;
    private String type;
}
