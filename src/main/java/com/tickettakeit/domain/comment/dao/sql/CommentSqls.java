package com.tickettakeit.domain.comment.dao.sql;

public class CommentSqls {
    public static final String INSERT_RESERVATION_COMMENT = "INSERT INTO reservation_user_comment(product_id, reservation_info_id, score, comment, create_date, modify_date) VALUES(:productId, :reservationInfoId, :score, :comment, NOW(), NOW())";
    public static final String SELECT_FILE_INFO = "SELECT ruc_image.id AS image_id, ruc_image.reservation_info_id, ruc_image.reservation_user_comment_id, fi.id AS file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date FROM reservation_user_comment_image ruc_image JOIN file_info fi ON ruc_image.file_id = fi.id WHERE ruc_image.reservation_info_id = :reservationInfoId limit 1";
    public static final String SELECT_COMMENT_BY_RESERVATION_INFO_ID = "SELECT id AS comment_id, comment, product_id, create_date, modify_date, reservation_info_id, score FROM reservation_user_comment WHERE reservation_info_id = :reservationInfoId limit 1";
}
