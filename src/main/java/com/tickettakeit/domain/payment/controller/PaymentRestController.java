package com.tickettakeit.domain.payment.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.tickettakeit.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PaymentRestController {
    private IamportClient iamportClient;
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${API_KEY_SECRET}")
    private String API_KEY_SECRET;
    private final PaymentService paymentService;

    @PostConstruct
    public void init() {
        this.iamportClient = new IamportClient(API_KEY, API_KEY_SECRET);
    }

    @PostMapping("/payments/confirm/{imp_uid}")
    public IamportResponse<Payment> paymentComplete(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }
    @PostMapping("/payments/complete/{imp_uid}")
    public Map<String, Integer> processOrder(@PathVariable String imp_uid) {
        int temp = paymentService.createOrderInfo(imp_uid);
        System.out.println(temp);
        return null;
    }
}
