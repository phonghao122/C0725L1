package com.example.ss4.service;

import com.example.ss4.entity.Product;
import com.example.ss4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public boolean save(Product product) {
        if (product != null){
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        Product product = productRepository.findById(id);
        if (product != null){
            productRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        Product findProduct = productRepository.findById(product.getId());
        if (findProduct != null){
            productRepository.update(product);
            return true;
        }
        return false;
    }
}
