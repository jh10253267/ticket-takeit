package com.tickettakeit.domain.reservation.dto;

import com.tickettakeit.domain.displayinfo.dto.DisplayInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInfo {
    private Integer productId;
    private boolean cancelYn;
    private String createDate;
    private DisplayInfo displayInfo;
    private Integer displayInfoId;
    private String modifyDate;
    private Integer reservationInfoId;
    private String reservationDate;
    private String reservationEmail;
    private String reservationName;
    private String reservationTelephone;
    private int totalPrice;
}
