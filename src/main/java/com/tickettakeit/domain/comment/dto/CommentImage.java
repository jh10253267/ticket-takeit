package com.tickettakeit.domain.comment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentImage {
    private Integer imageId;
    private Integer reservationInfoId;
    private Integer reservationUserCommentId;
    private Integer fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private String createDate;
    private String modifyDate;
}
