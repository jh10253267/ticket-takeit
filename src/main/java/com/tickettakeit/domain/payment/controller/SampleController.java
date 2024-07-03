package com.tickettakeit.domain.payment.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SampleController {
    private IamportClient iamportClient;
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${API_KEY_SECRET}")
    private String API_KEY_SECRET;

    public SampleController() {
        this.iamportClient = new IamportClient(API_KEY, API_KEY_SECRET);
    }

    @PostMapping("/payments/complete")
    public IamportResponse<Payment> paymentComplete(@RequestParam String imp_uid) throws IamportResponseException, IOException {
        System.out.println(imp_uid);
        return iamportClient.paymentByImpUid(imp_uid);
    }
}
