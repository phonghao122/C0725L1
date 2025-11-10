package ss12.common;

import ss12.entity.Product;

import java.util.Scanner;

public class ProductInput {
    public static Product productInput() {
        Product product = new Product();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter Product Id:");
            String id = sc.nextLine();
            if (CheckInput.checkInteger(id)){
                product.setId(Integer.parseInt(id));
            }
            System.out.println("Enter Product Name:");
            product.setName(sc.nextLine());
            System.out.println("Enter Product Price:");
            String price = sc.nextLine();
            if (CheckInput.checkDouble(price)){
                product.setPrice(Double.parseDouble(price));
            }
            System.out.println("Enter Product Quantity:");
            String quantity = sc.nextLine();
            if (CheckInput.checkInteger(quantity)){
                product.setQuantity(Integer.parseInt(quantity));
            }
            System.out.println("Enter Product Category:");
            product.setCategory(sc.nextLine());
            return product;
        }catch (Exception e){
            System.out.println("Invalid Input");
            return null;
        }
    }
}
