package com.example.productmanager.repository;

import com.example.productmanager.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"13 Promax",10000000,50));
        products.add(new Product(2,"14 Promax",15000000,50));
        products.add(new Product(3,"15 Promax",20000000,50));
        products.add(new Product(4,"16 Promax",25000000,50));
        products.add(new Product(5,"17 Promax",30000000,50));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean add(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
