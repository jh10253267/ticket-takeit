package com.tickettakeit.domain.promotion.dao.sql;

public class PromotionSqls {
    public static final String SELECT_ALL_PROMOTIONS = "SELECT promotion.id, promotion.product_id, file_info.id AS file_id, file_info.save_file_name AS productImageUrl FROM promotion JOIN product_image ON promotion.product_id = product_image.product_id AND product_image.type='th' JOIN file_info ON product_image.file_id = file_info.id";
}
