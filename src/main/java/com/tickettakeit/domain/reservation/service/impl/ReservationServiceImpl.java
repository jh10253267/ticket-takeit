package com.tickettakeit.domain.reservation.service.impl;

import com.tickettakeit.domain.displayinfo.dao.DisplayInfoDAO;
import com.tickettakeit.domain.displayinfo.dto.DisplayInfo;
import com.tickettakeit.domain.reservation.dao.ReservationDAO;
import com.tickettakeit.domain.reservation.dto.*;
import com.tickettakeit.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO;
    private final DisplayInfoDAO displayInfoDAO;
    @Override
    public ReservationInfoResponse getReservationInfo(String reservationEmail) {
        List<ReservationInfo> reservationInfos = reservationDAO.selectReservationInfoByEmail(reservationEmail);
        for (ReservationInfo reservationInfo : reservationInfos) {
            DisplayInfo displayInfo = displayInfoDAO.selectDisplayInfo(reservationInfo.getDisplayInfoId());
            reservationInfo.setDisplayInfo(displayInfo);

            int totalPrice = 0;
            List<ReservationTotalPrice> reservationTotalPrices = reservationDAO.selectReservationTotalPrices(reservationInfo.getReservationInfoId());
            for (ReservationTotalPrice reservationTotalPrice : reservationTotalPrices) {
                totalPrice += reservationTotalPrice.getPrice() * reservationTotalPrice.getCount();
            }

            reservationInfo.setTotalPrice(totalPrice);
        }
        return new ReservationInfoResponse(reservationInfos, reservationInfos.size());
    }

    @Override
    @Transactional
    public ReservationResponse reserve(ReservationParam reservationParam) {
        Integer reservationInfoId = reservationDAO.insertReservationInfo(ReservationRequest.fromReservationParam(reservationParam));
        ReservationResponse reservationResponse = reservationDAO.selectReservationInfoById(reservationInfoId);
        List<ReservationPrice> prices = reservationParam.getPrices().stream()
                .peek(price -> price.setReservationInfoId(reservationInfoId))
                .collect(Collectors.toList());

        List<ReservationPrice> resultPrices = new ArrayList<>();
        for(ReservationPrice reservationPrice : prices) {
            resultPrices.add(reservationDAO.insertReservationPriceInfo(reservationPrice));
        }

        reservationResponse.setPrices(resultPrices);
        reservationResponse.setReservationInfoId(reservationInfoId);

        return reservationResponse;
    }

    @Override
    @Transactional
    public ReservationResponse cancelReservations(Integer reservationId) {
        ReservationResponse reservationResponse = reservationDAO.selectReservationInfoById(reservationId);
        reservationResponse.setPrices(reservationDAO.selectReservationInfoPrices(reservationId));

        reservationDAO.deleteReservationInfoPrices(reservationId);
        reservationDAO.deleteReservationInfo(reservationId);

        return reservationResponse;
    }

    @Override
    public LocalDate generateRandomDate() {
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        LocalDate currentDate = LocalDate.now();
        LocalDate afterRandomDays = currentDate.plusDays(randomNumber);
        return afterRandomDays;
    }
}
