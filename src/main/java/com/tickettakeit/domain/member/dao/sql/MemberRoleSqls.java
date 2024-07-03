package com.tickettakeit.domain.member.dao.sql;

public class MemberRoleSqls {
    public static final String SELECT_ALL_BY_EMAIL = "SELECT mr.id, mr.member_id, mr.role_name FROM member_role mr JOIN member m ON mr.member_id = m.id WHERE m.email = :email";
}
