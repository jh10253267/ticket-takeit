package com.tickettakeit.domain.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private Integer productId;
    private Integer displayInfoId;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private String reservationDate;
    private boolean cancelYn;
    private String createDate;
    private String modifyDate;
    List<ReservationPrice> prices;
}
