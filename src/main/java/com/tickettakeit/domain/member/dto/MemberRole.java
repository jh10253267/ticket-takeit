package com.tickettakeit.domain.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRole {
    private Long id;
    private Long memberId;
    private String roleName;

    public MemberRole(Long memberId, String roleName) {
        this.memberId = memberId;
        this.roleName = roleName;
    }
}
