package com.tickettakeit.domain.comment.controller;

import com.tickettakeit.domain.comment.dto.CommentResponse;
import com.tickettakeit.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class CommentRestController {
    private final CommentService commentService;

    @PostMapping("/{reservationInfoId}/comments")
    public CommentResponse writeComment(@PathVariable("reservationInfoId") Integer reservationInfoId,
                                        @RequestParam(value = "attachedImage", required = false) MultipartFile attachedImage,
                                        @RequestParam("comment")String comment,
                                        @RequestParam("productId")Integer productId,
                                        @RequestParam("score")int score) {
        return commentService.writeComment(attachedImage, comment, productId, reservationInfoId, score);
    }
}
