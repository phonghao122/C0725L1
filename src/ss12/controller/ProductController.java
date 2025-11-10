package ss12.controller;

import ss12.entity.Product;
import ss12.service.ProductService;

import java.util.List;

public class ProductController {
    private final ProductService productService;
    public ProductController() {
        productService = new ProductService();
    }

    public List<Product> findAll() {
        return productService.findAll();
    }
    public Product findById(int id) {
        return productService.findById(id);
    }
    public boolean save(Product product) {
        return productService.save(product);
    }
    public boolean delete(int id) {
        return productService.delete(id);
    }
    public boolean update(Product product) {
        return productService.update(product);
    }
    public List<Product> searchProduct(String search) {
        return productService.searchProduct(search);
    }
}
