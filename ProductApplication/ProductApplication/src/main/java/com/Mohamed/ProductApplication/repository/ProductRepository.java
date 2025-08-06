package com.Mohamed.ProductApplication.repository;

import com.Mohamed.ProductApplication.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {
}
