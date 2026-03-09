package com.example.productmanager.repository;

import com.example.productmanager.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean deleteById(int id);
}
