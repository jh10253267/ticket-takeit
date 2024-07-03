package com.tickettakeit.domain.reservation.dao;

import com.tickettakeit.domain.reservation.dto.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tickettakeit.domain.reservation.dao.sql.ReserveSqls.*;

@Repository
public class ReservationDAO {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert priceInsert;
    private final RowMapper<ReservationInfo> reservationInfoRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private final RowMapper<ReservationResponse> reservationResponseRowMapper = BeanPropertyRowMapper.newInstance(ReservationResponse.class);
    private final RowMapper<ReservationPrice> reservationPriceRowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
    private final RowMapper<ReservationTotalPrice> reservationTotalPriceRowMapper = BeanPropertyRowMapper.newInstance(ReservationTotalPrice.class);

    public ReservationDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.priceInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("reservation_info_price");
    }

    public ReservationResponse selectReservationInfoById(Integer reservationId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationId);
        return jdbc.queryForObject(SELECT_RESERVATION_INFO_BY_ID, params, reservationResponseRowMapper);
    }
    public  List<ReservationInfo> selectReservationInfoByEmail(String reservationEmail) {
        Map<String, String> params = new HashMap<>();
        params.put("reservationEmail", reservationEmail);
        return jdbc.query(SELECT_RESERVATION_INFO_BY_EMAIL, params, reservationInfoRowMapper);
    }
    public List<ReservationPrice> selectReservationInfoPrices(Integer reservationId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationId);
        return jdbc.query(SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID, params, reservationPriceRowMapper);
    }
    public List<ReservationTotalPrice> selectReservationTotalPrices(Integer reservationId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationId);

        return jdbc.query(SELECT_RESERVATION_TOTAL_PRICE, params, reservationTotalPriceRowMapper);
    }
    public Integer insertReservationInfo(ReservationRequest reservationRequest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationRequest);
        jdbc.update(INSERT_RESERVATION_INFO, params, keyHolder);

        return keyHolder.getKey().intValue();
    }
    public ReservationPrice insertReservationPriceInfo(ReservationPrice price) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(price);
        price.setReservationInfoPriceId(priceInsert.executeAndReturnKey(params).intValue());

        return price;
    }
    public Integer deleteReservationInfoPrices(Integer reservationId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationId);

        return jdbc.update(DELETE_RESERVATION_INFO_PRICE_BY_RESERVATION_INFO_ID, params);
    }
    public Integer deleteReservationInfo(Integer reservationId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationId);

        return jdbc.update(DELETE_RESERVATION_INFO_BY_ID, params);
    }
}