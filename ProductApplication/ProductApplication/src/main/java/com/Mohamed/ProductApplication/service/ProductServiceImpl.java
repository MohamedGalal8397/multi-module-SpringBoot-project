package com.Mohamed.ProductApplication.service;

import com.Mohamed.ProductApplication.model.entity.ProductEntity;
import com.Mohamed.ProductApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepository ;


    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public Optional<ProductEntity> getProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean productExist(int id) {
        return productRepository.existsById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
