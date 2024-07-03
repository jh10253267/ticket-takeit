package com.tickettakeit.domain.displayinfo.dto;

import com.tickettakeit.domain.comment.dto.Comment;
import com.tickettakeit.domain.product.dto.ProductImage;
import com.tickettakeit.domain.product.dto.ProductPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DisplayInfoResponse {
    private BigDecimal averageScore;
    private List<Comment> comments;
    private DisplayInfo displayInfo;
    private DisplayInfoImage displayInfoImage;
    private List<ProductImage> productImages;
    private List<ProductPrice> productPrices;
}
