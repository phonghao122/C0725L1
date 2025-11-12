package ss12.service;

import ss12.entity.Product;
import ss12.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    public  ProductService() {
        productRepository = new ProductRepository();
    }
    @Override
    public boolean save(Product product) {
        try {
            productRepository.addProduct(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        if (productRepository.findProductById(product.getId())==null){
            return false;
        }else {
            productRepository.updateProduct(product);
            return true;
        }
    }

    @Override
    public boolean delete(int id) {
        if (productRepository.findProductById(id)==null){
            return false;
        }else {
            productRepository.removeProduct(id);
            return true;
        }
    }

    @Override
    public Product findById(int id) {
        if (productRepository.findProductById(id)==null){
            return null;
        }else {
            return productRepository.findProductById(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean existsId(int id) {
        return productRepository.findProductById(id) != null;
    }

    private List<Product> findAllByName(String name) {
        return productRepository.findProductByName(name);
    }

    private List<Product> findProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public List<Product> searchProduct(String search) {
        Set<Product> productSet = new HashSet<>();
        productSet.addAll(findAllByName(search));
        productSet.addAll(findProductByCategory(search));
        List<Product> productList = new ArrayList<>(productSet);
        if(productList.isEmpty()){
            return null;
        }
        return productList;
    }

    @Override
    public List<Product> findAllByPrice(double minPrice, double maxPrice) {
        return productRepository.findAllByPrice(minPrice, maxPrice);
    }
}
