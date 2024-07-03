package com.tickettakeit.domain.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInfoResponse {
    private List<ReservationInfo> reservations;
    private int size;
}
