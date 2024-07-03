package com.tickettakeit.domain.displayinfo.service.impl;

import com.tickettakeit.domain.comment.dto.Comment;
import com.tickettakeit.domain.displayinfo.dao.DisplayInfoDAO;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfo;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfoImage;
import com.tickettakeit.domain.displayinfo.service.DisplayInfoService;
import com.tickettakeit.domain.product.dto.ProductImage;
import com.tickettakeit.domain.product.dto.ProductPrice;
import com.tickettakeit.domain.product.enums.PriceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisplayInfoServiceImpl implements DisplayInfoService {
    private final DisplayInfoDAO displayInfoDAO;

    public DisplayInfo getDisplayInfo(Integer displayInfoId) {
        return displayInfoDAO.selectDisplayInfo(displayInfoId);
    }

    public DisplayInfoImage getDisplayInfoImage(Integer displayInfoId) {
        return displayInfoDAO.selectDisplayInfoImage(displayInfoId);
    }

    public List<Comment> getComments(Integer displayInfoId) {
        List<Comment> comments = displayInfoDAO.selectComments(displayInfoId)
                .stream()
                .map(comment -> {
                    comment.setCommentImage(displayInfoDAO.selectCommentImages(comment.getCommentId()));
                    return comment;
                })
                .collect(Collectors.toList());

        return comments;
    }
    public List<ProductImage> getProductImages(Integer displayInfoId) {
        return displayInfoDAO.selectProductImages(displayInfoId);
    }
    public List<ProductPrice> getProductPrices(Integer displayInfoId) {
        return displayInfoDAO.selectProductPrices(displayInfoId)
                .stream()
                .map(value -> {
                    value.setPriceTypeName(PriceType.priceType(value.getPriceTypeName()));
                    return value;
                }).collect(Collectors.toList());
    }
    public BigDecimal getAverageScore(Integer displayInfoId) {
        return displayInfoDAO.selectAverageScore(displayInfoId);
    }
}
