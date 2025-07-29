package com.sarvesh.productServiceJuly25.controller;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {


        return new ResponseEntity<>(productService.getSingleProduct(productId),HttpStatus.OK);

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
    // here we are handling exception locally means this local exception handler so it will be given priority first
    //and if we would not have handle it here then it would have to gone to controller advice for additional check
//    @ExceptionHandler(ProductNotFoundException.class)
//    private String handleProductNotFound(){
//        return "productNotFound oye hoye";
//    }

}
