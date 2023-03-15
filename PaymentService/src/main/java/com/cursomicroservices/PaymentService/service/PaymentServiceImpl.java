package com.cursomicroservices.PaymentService.service;

import com.cursomicroservices.PaymentService.entity.TransactionDetails;
import com.cursomicroservices.PaymentService.model.PaymentMode;
import com.cursomicroservices.PaymentService.model.PaymentRequest;
import com.cursomicroservices.PaymentService.model.PaymentResponse;
import com.cursomicroservices.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);
        TransactionDetails transactionDetails =
                TransactionDetails
                .builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCESS")
                .orderId(paymentRequest.getOrderId())
                .amount(paymentRequest.getAmount())
                .build();

        transactionDetailsRepository.save(transactionDetails);

        log.info("Transaction Completed with Id: {}", transactionDetails.getId());

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {
        log.info("Getting payment details for the Order Id: {}",orderId);
        TransactionDetails transactionDetails =
                transactionDetailsRepository.findByOrderId(orderId);

        PaymentResponse paymentResponse =
                PaymentResponse
                        .builder()
                        .paymentId(transactionDetails.getId())
                        .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                        .paymentDate(transactionDetails.getPaymentDate())
                        .orderId(transactionDetails.getOrderId())
                        .status(transactionDetails.getPaymentStatus())
                        .amount(transactionDetails.getAmount())
                        .build();

        return paymentResponse;
    }
}
