package com.tickettakeit.domain.comment.dao;

import com.tickettakeit.domain.comment.dto.CommentImage;
import com.tickettakeit.domain.comment.dto.CommentResponse;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.tickettakeit.domain.comment.dao.sql.CommentSqls.*;

@Repository
public class CommentDAO {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert userCommentInsert;
    private final RowMapper<CommentImage> commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
    private final RowMapper<CommentResponse> commentResponseRowMapper = BeanPropertyRowMapper.newInstance(CommentResponse.class);
    public CommentDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.userCommentInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("reservation_user_comment_image");
    }

    public Integer insertReservationComment(String comment, Integer productId, Integer reservationInfoId, int score) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("comment", comment)
                .addValue("productId", productId)
                .addValue("reservationInfoId", reservationInfoId)
                .addValue("score", score);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(INSERT_RESERVATION_COMMENT, params, keyHolder);

        return keyHolder.getKey().intValue();
    }
    public Integer insertUserCommentImage(Integer reservationInfoId, Integer reservationUserCommentId, Integer fileId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("reservationInfoId", reservationInfoId)
                .addValue("reservationUserCommentId", reservationUserCommentId)
                .addValue("fileId", fileId);

        return userCommentInsert.executeAndReturnKey(params).intValue();
    }

    public CommentImage selectCommentFileInfo(Integer reservationInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationInfoId);
        try {
            return jdbc.queryForObject(SELECT_FILE_INFO, params, commentImageRowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    public CommentResponse selectCommentByReservationInfoId(Integer reservationInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("reservationInfoId", reservationInfoId);
        
        return jdbc.queryForObject(SELECT_COMMENT_BY_RESERVATION_INFO_ID, params, commentResponseRowMapper);
    }
}