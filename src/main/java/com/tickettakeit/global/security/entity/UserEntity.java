package com.tickettakeit.global.security.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private String username;
    private String password;
}
