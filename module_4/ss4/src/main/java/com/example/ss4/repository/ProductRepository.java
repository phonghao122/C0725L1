package com.example.ss4.repository;

import com.example.ss4.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        Product findProduct = entityManager.find(Product.class, product.getId());
        if (findProduct != null) {
            findProduct.setName(product.getName());
            findProduct.setPrice(product.getPrice());
            findProduct.setQuantity(product.getQuantity());
            findProduct.setDescription(product.getDescription());
        }
    }
}
