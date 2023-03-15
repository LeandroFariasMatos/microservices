package com.cursomicroservices.ProductService.service;

import com.cursomicroservices.ProductService.model.ProductRequest;
import com.cursomicroservices.ProductService.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    long addProduct(ProductRequest productRequest);
    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);
}
