package com.tickettakeit.domain.product.dao;

import com.tickettakeit.domain.product.dto.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tickettakeit.domain.product.dao.sql.ProductSqls.*;

@Repository
public class ProductDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Product> selectDisplayInfoByCategoryId(int categoryId, int cursor, int size) {
        Map<String, Integer> params = new HashMap<>();
        params.put("categoryId", categoryId);
        params.put("cursor", cursor);
        params.put("size", size);

        return jdbc.query(SELECT_DISPLAY_INFO_BY_CATEGORY_ID, params, rowMapper);
    }
    public List<Product> selectDisplayInfo(int start) {
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);

        return jdbc.query(SELECT_DISPLAY_INFO, params, rowMapper);
    }
    public int selectProductCount() {
        return jdbc.queryForObject(SELECT_PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
    }
    public int selectProductCountByCategoryId(int categoryId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("categoryId", categoryId);
        return jdbc.queryForObject(SELECT_PRODUCT_COUNT_BY_CATEGORY_ID, params, Integer.class);
    }
}
