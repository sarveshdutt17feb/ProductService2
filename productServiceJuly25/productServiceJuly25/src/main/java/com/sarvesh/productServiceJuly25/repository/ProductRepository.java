package com.sarvesh.productServiceJuly25.repository;

import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.repository.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long ProductId);

    @Override
    List<Product> findAll();
    @Query("select p.title as title,p.price as price from products p where p.id =:Id")
    ProductWithTitleAndPrice getTitleAndPriceById(@Param("Id") Long Id);
}
