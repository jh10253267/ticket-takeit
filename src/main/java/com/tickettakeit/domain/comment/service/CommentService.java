package com.tickettakeit.domain.comment.service;

import com.tickettakeit.domain.comment.dto.CommentResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CommentService {
    CommentResponse writeComment(MultipartFile attachedImage, String comment, Integer productId, Integer reservationInfoId, int score);

}
