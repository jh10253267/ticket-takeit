package com.tickettakeit.domain.displayinfo.service;

import com.tickettakeit.domain.comment.dto.Comment;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfo;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfoImage;
import com.tickettakeit.domain.product.dto.ProductImage;
import com.tickettakeit.domain.product.dto.ProductPrice;

import java.math.BigDecimal;
import java.util.List;

public interface DisplayInfoService {
    DisplayInfo getDisplayInfo(Integer displayInfoId);
    DisplayInfoImage getDisplayInfoImage(Integer displayInfoId);
    List<Comment> getComments(Integer displayInfoId);
    List<ProductImage> getProductImages(Integer displayInfoId);
    List<ProductPrice> getProductPrices(Integer displayInfoId);
    BigDecimal getAverageScore(Integer displayInfoId);
}
