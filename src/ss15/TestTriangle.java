package ss15;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh a: ");
            double a = sc.nextDouble();

            System.out.print("Nhập cạnh b: ");
            double b = sc.nextDouble();

            System.out.print("Nhập cạnh c: ");
            double c = sc.nextDouble();

            TriangleChecker.checkTriangle(a, b, c);

        } catch (IllegalTriangleException e) {
            System.err.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Giá trị nhập vào không hợp lệ!");
        }
    }
}

