package com.tickettakeit.domain.reservation.service;

import com.tickettakeit.domain.reservation.dto.ReservationInfoResponse;
import com.tickettakeit.domain.reservation.dto.ReservationParam;
import com.tickettakeit.domain.reservation.dto.ReservationResponse;

import java.time.LocalDate;

public interface ReservationService {
    ReservationInfoResponse getReservationInfo(String email);
    ReservationResponse reserve(ReservationParam reservationParam);
    ReservationResponse cancelReservations(Integer reservationId);
    LocalDate generateRandomDate();

}
