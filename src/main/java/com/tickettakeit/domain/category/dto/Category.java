package com.tickettakeit.domain.category.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private int count;

}
