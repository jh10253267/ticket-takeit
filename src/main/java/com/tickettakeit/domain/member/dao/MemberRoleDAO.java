package com.tickettakeit.domain.member.dao;

import com.tickettakeit.domain.member.dto.MemberRole;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tickettakeit.domain.member.dao.sql.MemberRoleSqls.*;


@Repository
public class MemberRoleDAO {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<MemberRole> memberRoleRowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);
    private final SimpleJdbcInsert simpleJdbcInsert;

    public MemberRoleDAO(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member_role")
                .usingGeneratedKeyColumns("id");
    }

    public List<MemberRole> getRolesByEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        return jdbc.query(SELECT_ALL_BY_EMAIL, map, memberRoleRowMapper);
    }
    public void addMemberRole(Integer memberId, String roleName) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("roleName", roleName);

        simpleJdbcInsert.execute(params);
    }
}
