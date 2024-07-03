package com.tickettakeit.domain.category.dao;

import com.tickettakeit.domain.category.dto.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import static com.tickettakeit.domain.category.dao.sqls.CategorySqls.*;

import java.util.List;

@Repository
public class CategoryDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> categoryRowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    public CategoryDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public List<Category> selectAllCategories() {
        return jdbc.query(SELECT_ALL_CATEGORIES, categoryRowMapper);
    }
}
