package ss12.repository;

import ss12.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepository {
    private final List<Product> products;
    public ProductRepository() {
        products = new ArrayList<>();
    }
    public List<Product> findAll() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }
    public void updateProduct(Product product) {
        for(Product p : products) {
            if(Objects.equals(p.getId(), product.getId())) {
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
                p.setCategory(product.getCategory());
                p.setName(product.getName());
                break;
            }
        }
    }
    public Product findProductById(int id) {
        for(Product p : products) {
            if(Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(Objects.equals(p.getName().toLowerCase(), name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public  List<Product> findAllByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for(Product p : products) {
            if(Objects.equals(p.getCategory().toLowerCase(), category.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
