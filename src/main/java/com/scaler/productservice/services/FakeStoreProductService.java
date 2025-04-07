package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private final RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
       FakeStoreProductDto fakeStoreProductDto=
               restTemplate.getForObject("https://fakestoreapi.com/products/{id}/",FakeStoreProductDto.class,id);
        return fakeStoreProductDto.getProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(String title,String description,double price,String image,String category) {
        FakeStoreCreateProductRequestDto createProductRequestdto = new FakeStoreCreateProductRequestDto();
        createProductRequestdto.setTitle(title);
        createProductRequestdto.setDescription(description);
        createProductRequestdto.setPrice(price);
        createProductRequestdto.setImage(image);
        createProductRequestdto.setCategory(category);

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.postForObject("https://fakestoreapi.com/products",createProductRequestdto,
                        FakeStoreProductDto.class);

        return fakeStoreProductDto.getProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtosarray= restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class).getBody();
        /*ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtosarray = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);*/

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < fakeStoreProductDtosarray.length; i++) {
            products.add(fakeStoreProductDtosarray[i].getProduct(fakeStoreProductDtosarray[i]));
        }
        /*if(fakeStoreProductDtosarray.getStatusCode() == HttpStatus.OK){
            System.out.println(Arrays.toString(fakeStoreProductDtosarray.getBody()));
        } else if (fakeStoreProductDtosarray.getStatusCode() == HttpStatus.NOT_FOUND) {
            System.out.println(Arrays.toString(fakeStoreProductDtosarray.getBody()));
        }*/

        return products;
    }
}
