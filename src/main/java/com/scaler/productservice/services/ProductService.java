package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     Product getProductDetails(Long id);
     Product createProduct(String title,String description,double price,String image,String category);
     List<Product> getAllProducts();
}
