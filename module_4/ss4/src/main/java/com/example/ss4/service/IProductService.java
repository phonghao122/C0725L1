package com.example.ss4.service;

import com.example.ss4.entity.Product;

import java.util.List;

public interface IProductService {
    boolean save(Product product);
    List<Product> findAll();
    Product findById(int id);
    boolean delete(int id);
    boolean update(Product product);
}
