package com.tickettakeit.domain.member.dao.sql;

public class MemberSqls {
    public static final String SELECT_MEMBER_BY_EMAIL = "SELECT id, name, password, email, create_date, modify_date FROM member WHERE email = :email";
    public static final String INSERT_MEMBER_INFO = "INSERT INTO member(name, password, email, create_date, modify_date) VALUES(:name, :password, :email, NOW(), NOW())";
}
