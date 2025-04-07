package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FakeStoreCreateProductRequestDto {

    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
