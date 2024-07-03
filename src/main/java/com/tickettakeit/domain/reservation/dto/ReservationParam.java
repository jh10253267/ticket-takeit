package com.tickettakeit.domain.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationParam {
    private Integer displayInfoId;
    private List<ReservationPrice> prices;
    private Integer productId;
    private String reservationEmail;
    private String reservationName;
    private String reservationTelephone;
    private String reservationYearMonthDay;
}
