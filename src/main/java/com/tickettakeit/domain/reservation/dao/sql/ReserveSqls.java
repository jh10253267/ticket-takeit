package com.tickettakeit.domain.reservation.dao.sql;

public class ReserveSqls {
    public static final String SELECT_RESERVATION_INFO_BY_ID = "SELECT id AS reservation_info_id, product_id, display_info_id, reservation_name, reservation_tel AS reservation_telephone, reservation_email, reservation_date, cancel_flag AS cancel_yn, create_date, modify_date FROM reservation_info WHERE id = :reservationInfoId";
    public static final String SELECT_RESERVATION_INFO_BY_EMAIL = "SELECT id AS reservation_info_id, product_id, display_info_id, reservation_name, reservation_tel AS reservation_telephone, reservation_email, reservation_date, cancel_flag AS cancel_yn, create_date, modify_date FROM reservation_info WHERE reservation_email = :reservationEmail ORDER BY reservation_info_id DESC";
    public static final String SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID = "SELECT count, product_price_id, reservation_info_id, id AS reservation_info_price_id FROM reservation_info_price WHERE reservation_info_id = :reservationInfoId";
    public static final String SELECT_RESERVATION_TOTAL_PRICE = "SELECT product_price.price, reservation_info_price.count FROM reservation_info_price JOIN product_price ON product_price_id = product_price.id WHERE reservation_info_id = :reservationInfoId;";
    public static final String INSERT_RESERVATION_INFO = "INSERT INTO reservation_info(product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date) values(:productId, :displayInfoId, :reservationName, :reservationTel, :reservationEmail, :reservationDate, 0, NOW(), NOW())";
    public static final String DELETE_RESERVATION_INFO_BY_ID = "UPDATE reservation_info SET cancel_flag = true, modify_date = NOW() WHERE id = :reservationInfoId";
    public static final String DELETE_RESERVATION_INFO_PRICE_BY_RESERVATION_INFO_ID = "DELETE FROM reservation_info_price WHERE reservation_info_id = :reservationInfoId";
}
