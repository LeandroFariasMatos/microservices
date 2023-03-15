package com.cursomicroservices.OrderService.service;

import com.cursomicroservices.OrderService.model.OrderRequest;
import com.cursomicroservices.OrderService.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
