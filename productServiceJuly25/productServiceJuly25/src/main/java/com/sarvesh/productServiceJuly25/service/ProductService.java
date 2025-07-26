package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.model.Product;

import java.util.List;

public interface ProductService {


    public Product getSingleProduct(Long productId);
    public List<Product> getAllProduct();
    public Product createProduct(Product product);
    public void deleteProduct(Long productId);
    public void updateProduct(Long productId,Product product);
    public void replaceProduct(Long productId,Product product);










}
