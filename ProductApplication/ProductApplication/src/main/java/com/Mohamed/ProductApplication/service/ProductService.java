package com.Mohamed.ProductApplication.service;

import com.Mohamed.ProductApplication.model.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductEntity saveProduct(ProductEntity productEntity);
    Optional<ProductEntity> getProduct (int id);
    List<ProductEntity> getProducts();
    boolean productExist(int id );
    void deleteProduct(int id );





}
