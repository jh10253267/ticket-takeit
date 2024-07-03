package com.tickettakeit.domain.product.dao.sql;

public class ProductSqls {
    public static final String SELECT_DISPLAY_INFO_BY_CATEGORY_ID = "SELECT display_info.id AS display_info_id, display_info.product_id, file_info.id AS file_id, product.description AS product_description, display_info.place_name, product.content AS product_content, file_info.save_file_name AS productImageUrl FROM display_info JOIN product ON display_info.product_id = product.id JOIN product_image ON  product.id = product_image.product_id AND product_image.type='th' JOIN file_info ON product_image.file_id = file_info.id WHERE product.category_id = :categoryId AND display_info.id > :cursor LIMIT :size";
    public static final String SELECT_DISPLAY_INFO = "SELECT display_info.id AS display_info_id, display_info.product_id, file_info.id AS file_id, product.description AS product_description, display_info.place_name, product.content AS product_content, file_info.save_file_name AS productImageUrl FROM display_info JOIN product ON display_info.product_id = product.id JOIN product_image ON  product.id = product_image.product_id AND product_image.type='th' JOIN file_info ON product_image.file_id = file_info.id LIMIT 4 OFFSET :start";
    public static final String SELECT_PRODUCT_COUNT_BY_CATEGORY_ID = "SELECT COUNT(*) AS count FROM category JOIN product ON category.id = product.category_id JOIN display_info ON display_info.product_id = product.id where product.category_id = :categoryId";
    public static final String SELECT_PRODUCT_COUNT = "SELECT COUNT(*) AS count FROM display_info";
}
