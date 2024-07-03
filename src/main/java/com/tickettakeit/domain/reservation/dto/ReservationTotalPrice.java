package com.tickettakeit.domain.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationTotalPrice {
    private int price;
    private int count;
}
