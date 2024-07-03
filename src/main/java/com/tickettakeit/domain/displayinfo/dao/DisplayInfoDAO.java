package com.tickettakeit.domain.displayinfo.dao;

import com.tickettakeit.domain.comment.dto.Comment;
import com.tickettakeit.domain.comment.dto.CommentImage;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfo;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfoImage;
import com.tickettakeit.domain.product.dto.ProductImage;
import com.tickettakeit.domain.product.dto.ProductPrice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tickettakeit.domain.displayinfo.dao.sql.DisplayInfoSqls.*;

@Repository
public class DisplayInfoDAO {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<DisplayInfo> displayInfoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    private final RowMapper<DisplayInfoImage> displayInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
    private final RowMapper<ProductImage> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
    private final RowMapper<Comment> commentRowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
    private final RowMapper<CommentImage> commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
    private final RowMapper<ProductPrice> productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public DisplayInfoDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public DisplayInfo selectDisplayInfo(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.queryForObject(SELECT_DISPLAY_INFO, params, displayInfoRowMapper);
    }
    public DisplayInfoImage selectDisplayInfoImage(int displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.queryForObject(SELECT_DISPLAY_INFO_IMAGE, params, displayInfoImageRowMapper);
    }
    public List<Comment> selectComments(int displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.query(SELECT_COMMENTS, params, commentRowMapper);
    }
    public List<CommentImage> selectCommentImages(int commentId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("commentId", commentId);

        return jdbc.query(SELECT_COMMENT_IMAGES, params, commentImageRowMapper);
    }

    public List<ProductImage> selectProductImages(int displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.query(SELECT_PRODUCT_MAIN_IMAGE, params, productImageRowMapper);
    }
    public List<ProductPrice> selectProductPrices(int displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.query(SELECT_PRODUCT_PRICE, params, productPriceRowMapper);
    }

    public BigDecimal selectAverageScore(int displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);

        return jdbc.queryForObject(SELECT_AVG_SCORE, params, BigDecimal.class);
    }
}
