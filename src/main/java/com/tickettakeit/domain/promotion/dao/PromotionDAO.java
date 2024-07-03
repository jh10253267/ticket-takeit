package com.tickettakeit.domain.promotion.dao;

import com.tickettakeit.domain.promotion.dto.Promotion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static com.tickettakeit.domain.promotion.dao.sql.PromotionSqls.*;

@Repository
public class PromotionDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Promotion> promotionRowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

    public PromotionDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public List<Promotion> selectAllPromotion() {
        return jdbc.query(SELECT_ALL_PROMOTIONS, promotionRowMapper);
    }
}
