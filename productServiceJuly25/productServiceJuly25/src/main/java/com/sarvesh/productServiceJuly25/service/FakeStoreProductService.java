package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.dto.FakeStoreProductDto;

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
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class).getBody();
        //coverting FakeStore
        System.out.println(productDto);
        Product product = convertFakeStoreProductDtoToProduct(productDto);
        System.out.println(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
       List<FakeStoreProductDto> productDtos =  restTemplate.getForObject("https://fakestoreapi.com/products",List<FakeStoreProductDto>.class);//
        /* here the error we get beacuse we are using List of generics, and there will type eraser propert
        which will be applicable on generics which will erase the data type of generic at run time and it will be a raw list
        and here we are saying convert the response of api to List<FakeStoreDto> at run time which is contradicting in case of generics
        so what is the solution:
        solution is use array , because type eraser property is related to or applied on generics
        use FakeStoreDto[] fakeStoreDtos

       */
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
