package com.tickettakeit.domain.reservation.controller;

import com.tickettakeit.domain.reservation.dto.ReservationInfoResponse;
import com.tickettakeit.domain.reservation.dto.ReservationParam;
import com.tickettakeit.domain.reservation.dto.ReservationResponse;
import com.tickettakeit.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationRestController {
    private final ReservationService reservationService;
    @GetMapping
    public ReservationInfoResponse getReservations(Principal principal) {
        return reservationService.getReservationInfo(principal.getName());
    }

    @PostMapping
    public ReservationResponse reserve(@RequestBody ReservationParam reservationParam) {
        return reservationService.reserve(reservationParam);
    }
    @PutMapping("/{reservationId}")
    public ReservationResponse cancelReservations(@PathVariable("reservationId") Integer reservationId) {
        return reservationService.cancelReservations(reservationId);
    }
    
}
