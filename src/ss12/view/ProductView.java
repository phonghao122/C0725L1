package ss12.view;

import ss12.common.CheckInput;
import ss12.common.DisplayProduct;
import ss12.common.ProductInput;
import ss12.controller.ProductController;
import ss12.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final ProductController productController;
    public ProductView(){
        productController = new ProductController();
    }
    public void productView() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n--- PRODUCT VIEW ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("0. Quay lại menu chính");
            System.out.print("👉 Chọn: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("➡️ Thực hiện thêm sản phẩm...");
                    Product product = null;
                    do {
                         product = ProductInput.productInput();
                    }while (product == null);
                    if (productController.save(product)) {
                        System.out.println("Thêm sản phẩm thành công");
                    }else {
                        System.out.println("Thêm sản phẩm thất bại");
                    }
                    break;
                case 2:
                    System.out.println("➡️ Hiển thị danh sách sản phẩm...");
                    List<Product> products = productController.findAll();
                    if(products.isEmpty()){
                        System.out.println("Chưa có sản phẩm nào");
                    }else {
                        DisplayProduct.displayProductList(products);
                    }
                    break;
                case 3:
                    System.out.println("➡️ Tìm kiếm sản phẩm...");
                    System.out.print("Nhập từ khóa: ");
                    List<Product> products1 = productController.searchProduct(sc.nextLine());
                    if(products1 == null){
                        System.out.println("Không có sản phẩm cần tìm");
                    }else {
                        DisplayProduct.displayProductList(products1);
                    }
                    break;
                case 4:
                    System.out.println("➡️ Cập nhật sản phẩm...");
                    do {
                        product = ProductInput.productInput();
                    }while (product == null);
                    if (productController.update(product)) {
                        System.out.println("Cập nhật sản phẩm thành công");
                    }else {
                        System.out.println("Cập nhật sản phẩm thất bại");
                    }
                    break;
                case 5:
                    System.out.println("➡️ Xóa sản phẩm...");
                    while (true){
                        System.out.println("Nhập id: ");
                        String id = sc.nextLine();
                        if (CheckInput.checkInteger(id)) {
                            if (productController.delete(Integer.parseInt(id))) {
                                System.out.println("Xóa sản phẩm thành công");
                            }else {
                                System.out.println("Xóa sản phẩm thất bại");
                            }
                        }
                        break;
                    }
                    break;
                case 0:
                    System.out.println("↩️ Quay lại menu chính...");
                    break;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ!");
            }
        }while (option != 0);
    }
}
