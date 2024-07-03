package com.tickettakeit.domain.comment.service.impl;

import com.tickettakeit.domain.comment.dao.CommentDAO;
import com.tickettakeit.domain.comment.dto.CommentImage;
import com.tickettakeit.domain.comment.dto.CommentResponse;
import com.tickettakeit.domain.comment.service.CommentService;
import com.tickettakeit.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final FileService fileService;

    @Override
    public CommentResponse writeComment(MultipartFile attachedImage, String comment, Integer productId, Integer reservationInfoId, int score) {
        Integer reservationUserCommentId = commentDAO.insertReservationComment(comment, productId, reservationInfoId, score);

        if (attachedImage != null) {
            Integer fileId = fileService.uploadFile(attachedImage);
            commentDAO.insertUserCommentImage(reservationInfoId, reservationUserCommentId, fileId);
        }

        return this.responseComment(reservationInfoId);
    }
    private CommentResponse responseComment(Integer reservationInfoId) {
        CommentResponse commentResponse = commentDAO.selectCommentByReservationInfoId(reservationInfoId);
        CommentImage commentImage = commentDAO.selectCommentFileInfo(reservationInfoId);
        commentResponse.setCommentImage(commentImage);

        return commentResponse;
    }
}
