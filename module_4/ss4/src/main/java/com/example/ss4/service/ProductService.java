package com.example.ss4.service;

import com.example.ss4.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private List<Product> products;
    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1, "12 Promax", 10000000, 10, "Description 1"));
        products.add(new Product(2, "13 Promax", 20000000, 20, "Description 2"));
        products.add(new Product(3, "14 Promax", 30000000, 30, "Description 3"));
        products.add(new Product(4, "15 Promax", 40000000, 40, "Description 4"));
        products.add(new Product(5, "16 Promax", 50000000, 50, "Description 5"));
    }
    @Override
    public boolean save(Product product) {
        if (product != null) {
            products.add(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    @Override
    public boolean update(Product product) {
        Product findProduct = findById(product.getId());
        if (findProduct != null) {
            products.remove(findProduct);
            findProduct.setName(product.getName());
            findProduct.setPrice(product.getPrice());
            findProduct.setQuantity(product.getQuantity());
            findProduct.setDescription(product.getDescription());
            products.add(findProduct);
            return true;
        }
        return false;
    }
}
