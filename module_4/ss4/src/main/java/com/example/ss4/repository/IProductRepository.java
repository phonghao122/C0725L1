package com.example.ss4.repository;

import com.example.ss4.entity.Product;

import java.util.List;

public interface IProductRepository {
    void save(Product product);
    List<Product> findAll();
    Product findById(int id);
    void delete(int id);
    void update(Product product);
}
