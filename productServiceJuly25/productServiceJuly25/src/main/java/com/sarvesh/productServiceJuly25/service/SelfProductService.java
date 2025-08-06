package com.sarvesh.productServiceJuly25.service;

import com.sarvesh.productServiceJuly25.exception.ProductNotFoundException;
import com.sarvesh.productServiceJuly25.model.Category;
import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.repository.CategoryRepository;
import com.sarvesh.productServiceJuly25.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("SelfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("product not found with id = "+productId);
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getCategory() != null) {
            if (product.getCategory().getId() == null) {
                //Create a Category first.
                Category category = product.getCategory();

                String categoryValue = category.getValue();

                Optional<Category> optionalCategory = categoryRepository.findByValue(categoryValue);

                if (optionalCategory.isEmpty()) {
                    category = categoryRepository.save(category);
                    product.setCategory(category);
                } else {
                    product.setCategory(optionalCategory.get());
                }
            }
        } else {
            throw new RuntimeException("Category can't be empty while creating a Product.");
        }

        return productRepository.save(product);
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
