package com.sarvesh.productServiceJuly25.repository;

import com.sarvesh.productServiceJuly25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long ProductId);

    @Override
    List<Product> findAll();
}
