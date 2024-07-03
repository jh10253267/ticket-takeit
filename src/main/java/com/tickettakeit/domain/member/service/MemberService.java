package com.tickettakeit.domain.member.service;


import com.tickettakeit.domain.member.dto.Member;
import com.tickettakeit.global.security.entity.UserEntity;
import com.tickettakeit.global.security.entity.UserRoleEntity;

import java.util.List;

public interface MemberService {
    UserEntity getUser(String loginEmail);
    List<UserRoleEntity> getUserRoles(String loginUserId);
    void addMember(Member member, boolean isAdmin);
    Member getMemberByEmail(String loginId);
}
