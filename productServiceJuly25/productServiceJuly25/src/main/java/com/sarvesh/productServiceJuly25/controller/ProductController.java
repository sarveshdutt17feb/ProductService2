package com.sarvesh.productServiceJuly25.controller;

import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId){

        return productService.getSingleProduct(productId);
    }
    @GetMapping()
    public List<Product> getAllProduct(){

        return productService.getAllProduct();
    }

    public Product createProduct(@RequestBody Product product){
        return new Product();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }
    @PatchMapping("/{id}")//
    public void updateProduct(@PathVariable("id") Long id,@RequestBody Product product){

    }
    @PutMapping
    public void replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){

    }

}
