package com.tickettakeit.domain.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private String comment;
    private Integer commentId;
    private List<CommentImage> commentImage;
    private String createDate;
    private String modifyDate;
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private BigDecimal score;
}
