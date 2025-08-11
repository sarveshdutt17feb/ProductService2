package com.sarvesh.productServiceJuly25.controller;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.service.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

    @SpringBootTest
    class ProductControllerTest {
        @Autowired
        private ProductController productController;
        @MockitoBean(name = "SelfProductService")
        private ProductService productService;

    @Test
    void getSingleProductTest() throws ProductNotFoundException {
        //Arrange
        Product expectedProduct = new Product();
        expectedProduct.setTitle("iPhone 15 pro");
        expectedProduct.setPrice(100000.0);
        expectedProduct.setDescription("Apple");

        //Mocking
        when(productService.getSingleProduct(20L))
                .thenReturn(expectedProduct);

        //Act
        Product actualProduct = productController.getSingleProduct(20L).getBody();

        //Assert
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void getAllProduct() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void replaceProduct() {
    }
}