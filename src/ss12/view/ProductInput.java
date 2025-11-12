package ss12.view;

import ss12.common.CheckInput;
import ss12.entity.Product;

import java.util.Scanner;

public class ProductInput {
    public static Product productInput() {
        Product product = new Product();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Product Name:");
            String name = sc.nextLine();
            if (CheckInput.checkName(name)) {
                product.setName(sc.nextLine());
            }
            System.out.println("Enter Product Price:");
            String price = sc.nextLine();
            if (CheckInput.checkPrice(price)) {
                product.setPrice(Double.parseDouble(price));
            }
            System.out.println("Enter Product Quantity:");
            String quantity = sc.nextLine();
            if (CheckInput.checkQuantity(quantity)) {
                product.setQuantity(Integer.parseInt(quantity));
            }
            System.out.println("Enter Product Category:");
            product.setCategory(sc.nextLine());
            return product;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
