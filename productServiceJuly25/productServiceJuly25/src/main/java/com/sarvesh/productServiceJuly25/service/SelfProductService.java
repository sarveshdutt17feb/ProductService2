package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("SelfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct==null){
            throw new ProductNotFoundException("product not found",productId);
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
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
}
