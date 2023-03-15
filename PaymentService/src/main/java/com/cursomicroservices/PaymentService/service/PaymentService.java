package com.cursomicroservices.PaymentService.service;

import com.cursomicroservices.PaymentService.model.PaymentRequest;
import com.cursomicroservices.PaymentService.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
