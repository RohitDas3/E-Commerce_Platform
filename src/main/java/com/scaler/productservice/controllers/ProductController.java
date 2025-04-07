package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestdto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductDetails(@PathVariable("id") Long id) {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(productService.getProductDetails(id),
                HttpStatus.valueOf(401));
        return responseEntity;

    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestdto createProductRequestdto ) {
        Product product = productService.createProduct(
                createProductRequestdto.getTitle(),
                createProductRequestdto.getDescription(),
                createProductRequestdto.getPrice(),
                createProductRequestdto.getImage(),
                createProductRequestdto.getCategory()
        );

         ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.valueOf(200));

         return responseEntity;

    }
}
