package com.tickettakeit.domain.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {
    // 사용자 로그인 이메일
    private String email;
    // 비밀번호와 확인 비밀번호
    private String password;
    private String confirmPassword;
    // 사용자 실명
    private String name;
}
