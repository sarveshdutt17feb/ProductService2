package com.sarvesh.productServiceJuly25.repository;

import com.sarvesh.productServiceJuly25.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    Category save(Category category);

    @Override
    Optional<Category> findById(Long aLong);
    Optional<Category> findByValue(String value);

}
