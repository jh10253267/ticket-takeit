package com.tickettakeit.domain.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Integer displayInfoId;
    private Integer productId;
    private String reservationEmail;
    private String reservationName;
    private String reservationTel;
    private boolean cancelFlag;
    private String reservationDate;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public static ReservationRequest fromReservationParam(ReservationParam reservationParam) {
        return new ReservationRequest(
                reservationParam.getDisplayInfoId(),
                reservationParam.getProductId(),
                reservationParam.getReservationEmail(),
                reservationParam.getReservationName(),
                reservationParam.getReservationTelephone(),
                false,
                reservationParam.getReservationYearMonthDay(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
