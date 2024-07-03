package com.tickettakeit.domain.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationPrice {
    private int count;
    private int productPriceId;
    private int reservationInfoId;
    private int reservationInfoPriceId;
}
