package com.example.productmanager.service;

import com.example.productmanager.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
    boolean deleteById(int id);
}
