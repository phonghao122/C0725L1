package ss12.view;

import ss12.entity.Product;

import java.util.List;

public class DisplayProduct {
    public static void displayProduct(Product product){
        System.out.println("Product id: " + product.getId());
        System.out.println("Product name: " + product.getName());
        System.out.println("Product price: " + product.getPrice());
        System.out.println("Product quantity: " + product.getQuantity());
        System.out.println("Product category: " + product.getCategory());
    }

    public static void displayProductList(List<Product> productList){
        for(Product product:productList){
            displayProduct(product);
        }
    }
}
