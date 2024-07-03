package com.tickettakeit.domain.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Date createDate;
    private Date modifyDate;
}
