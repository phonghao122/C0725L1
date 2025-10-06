package Introduction_to_Java;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        System.out.println("Nhập số USD cần đổi: ");
        Scanner sc = new Scanner(System.in);
        float usd = sc.nextFloat();
        if(usd <= 0){
            System.out.println("USD không hợp lệ");
        }else {
            float vnd = (float) usd*23000;
            System.out.println("Kết quả: " + vnd + "VND");
        }
    }
}
