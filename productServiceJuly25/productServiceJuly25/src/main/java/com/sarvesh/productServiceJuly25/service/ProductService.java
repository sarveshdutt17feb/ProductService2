package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {


    public Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Page<Product> getAllProducts(int pageNumber, int pageSize);

    public Product createProduct(Product product);
    public void deleteProduct(Long productId);
    public void updateProduct(Long productId,Product product);
    public void replaceProduct(Long productId,Product product);










}
