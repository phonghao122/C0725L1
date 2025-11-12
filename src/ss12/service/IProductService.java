package ss12.service;

import ss12.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {

    List<Product> searchProduct(String search);
    List<Product> findAllByPrice(double minPrice, double maxPrice);
}
