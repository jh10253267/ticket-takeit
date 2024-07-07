package com.tickettakeit.domain.payment.service.impl;

import com.tickettakeit.domain.payment.dao.PaymentDAO;
import com.tickettakeit.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;

    @Override
    public int createOrderInfo(String impUid) {
        return paymentDAO.insertPaymentInfo(impUid);
//        paymentDAO.updateReservationPaymentFlag();
    }
}
