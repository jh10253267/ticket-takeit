package com.tickettakeit.domain.member.dao;

import com.tickettakeit.domain.member.dto.Member;
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
import java.util.Map;

import static com.tickettakeit.domain.member.dao.sql.MemberSqls.*;

@Repository
public class MemberDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
    private final SimpleJdbcInsert simpleJdbcInsert;

    public MemberDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public Member getMemberByEmail(String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        return jdbc.queryForObject(
                SELECT_MEMBER_BY_EMAIL, params, rowMapper);
    }

    public Integer addMember(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        jdbc.update(INSERT_MEMBER_INFO, params, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
