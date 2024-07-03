package com.tickettakeit.domain.payment.service.impl;

import kr.or.connect.reservation.domain.payment.dao.PaymentDAO;
import kr.or.connect.reservation.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;

    @Override
    public void createOrder(String impUid) {

    }
}
