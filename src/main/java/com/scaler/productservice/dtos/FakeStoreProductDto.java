package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private String price;
    private String category;
    private String image;

    public Product getProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product= new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(Double.parseDouble(fakeStoreProductDto.getPrice()));
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category =new Category();
        category.setName(fakeStoreProductDto.getCategory());
        category.setId((long)7948);
        product.setCategory(category);

        return product;
    }
}
