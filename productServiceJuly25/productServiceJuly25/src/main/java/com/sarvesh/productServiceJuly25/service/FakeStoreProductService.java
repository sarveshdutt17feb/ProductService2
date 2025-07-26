package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.dto.FakeStoreProductDto;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Category;
import com.sarvesh.productServiceJuly25.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
        //coverting FakeStore
        if(productDto==null){
            throw new ProductNotFoundException("Product not found",productId);
        }
        Product product = convertFakeStoreProductDtoToProduct(productDto);

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] fakeStoreProductDtos;
        FakeStoreProductDto[] productDtos =  restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);//solved problem due to type eraser property of generics by using FakeStroreDto[] (i.e using array)

       List<Product> products = new ArrayList<>();

       for(FakeStoreProductDto fakeStoreProductDto:productDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
       return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void updateProduct(Long productId, Product product) {

    }

    @Override
    public void replaceProduct(Long productId, Product product) {

    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setValue(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }
}
