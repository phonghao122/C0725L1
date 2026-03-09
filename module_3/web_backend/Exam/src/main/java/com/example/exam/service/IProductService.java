package com.example.exam.service;

import com.example.exam.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean deleteById(int id);
    boolean update(Product product);
    List<Product> findByCategory(int categoryId);
}
