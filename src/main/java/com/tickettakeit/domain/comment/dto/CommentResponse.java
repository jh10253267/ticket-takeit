package com.tickettakeit.domain.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {
    String comment;
    Integer commentId;
    CommentImage commentImage;
    String createDate;
    String modifyDate;
    Integer productId;
    Integer reservationInfoId;
    int score;
}
