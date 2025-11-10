package ss12.view;

import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // -----------------------------
            // Hiển thị menu chính
            // -----------------------------
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ =====");
            System.out.println("1. Product View");
            System.out.println("2. Customer View");
            System.out.println("0. Thoát");
            System.out.print("👉 Nhập lựa chọn của bạn: ");

            // Nhập lựa chọn từ người dùng
            choice = sc.nextInt();
            sc.nextLine(); // bỏ ký tự xuống dòng

            // -----------------------------
            // Xử lý lựa chọn
            // -----------------------------
            switch (choice) {
                case 1:
                    new ProductView().productView();
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("👋 Tạm biệt!");
                    break;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ. Vui lòng thử lại!");
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}
