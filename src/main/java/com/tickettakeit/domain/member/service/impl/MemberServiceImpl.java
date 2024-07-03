package com.tickettakeit.domain.member.service.impl;

import com.tickettakeit.domain.member.dao.MemberDAO;
import com.tickettakeit.domain.member.dao.MemberRoleDAO;
import com.tickettakeit.domain.member.dto.Member;
import com.tickettakeit.domain.member.dto.MemberRole;
import com.tickettakeit.domain.member.dto.MemberRoleEnum;
import com.tickettakeit.domain.member.service.MemberService;
import com.tickettakeit.global.security.entity.UserEntity;
import com.tickettakeit.global.security.entity.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.tickettakeit.domain.member.dto.MemberRoleEnum.ROLE_ADMIN;
import static com.tickettakeit.domain.member.dto.MemberRoleEnum.ROLE_USER;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final MemberRoleDAO memberRoleDAO;

    @Override
    @Transactional
    public UserEntity getUser(String loginEmail) {
        Member member = memberDAO.getMemberByEmail(loginEmail);
        return new UserEntity(member.getEmail(), member.getPassword());
    }

    @Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        List<MemberRole> memberRoles = memberRoleDAO.getRolesByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();
        for (MemberRole memberRole : memberRoles) {
            list.add(new UserRoleEntity(loginUserId, memberRole.getRoleName()));
        }

        return list;
    }

    @Override
    @Transactional
    public void addMember(Member member, boolean isAdmin) {
        Integer memberId = memberDAO.addMember(member);
        addMemberRole(memberId, isAdmin);
    }

    @Override
    public Member getMemberByEmail(String loginId) {
        return memberDAO.getMemberByEmail(loginId);
    }
    private void addMemberRole(Integer memberId, boolean isAdmin) {
        MemberRoleEnum role = isAdmin ? ROLE_ADMIN : ROLE_USER;
        memberRoleDAO.addMemberRole(memberId, role.toString());
    }

    private void validateEmail(String email) {
        System.out.println(memberDAO.getMemberByEmail(email));
    }

    private void validatePassword(String password, String confirmPassword) {
        // 패스워드가 일치하는지 확인
    }
}
