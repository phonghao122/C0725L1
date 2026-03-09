package com.example.productmanager.service;

import com.example.productmanager.entity.Product;
import com.example.productmanager.repository.IProductRepository;
import com.example.productmanager.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.deleteById(id);
    }
}
