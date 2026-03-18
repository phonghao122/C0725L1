package com.example.ss4.repository;

import com.example.ss4.entity.Product;
import com.example.ss4.util.ConnectionUtil;
import org.hibernate.Session;
import jakarta.persistence.TypedQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public boolean save(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Product> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("from Product");
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public Product findById(int id) {
            Session session = ConnectionUtil.sessionFactory.openSession();
            Product product = session.find(Product.class, id);
            session.close();
            if (product != null) {
                return product;
            }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product product = session.find(Product.class, id);
        if (product != null) {
            session.beginTransaction();
            session.remove(product);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public boolean update(Product product) {
        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            Product findProduct = session.find(Product.class, product.getId());

            if (findProduct == null) {
                return false;
            }

            findProduct.setName(product.getName());
            findProduct.setPrice(product.getPrice());
            findProduct.setQuantity(product.getQuantity());
            findProduct.setDescription(product.getDescription());

            // Không cần merge vì entity đã managed
            // session.merge(findProduct);

            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return false;
    }
}
