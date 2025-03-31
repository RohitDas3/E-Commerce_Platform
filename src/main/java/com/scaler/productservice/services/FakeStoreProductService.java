package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;
import org.springframework.web.client.RestTemplate;

public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
        restTemplate.getForObject("http://localhost:8080/products/" + id, Product.class);
        return null;
    }
}
