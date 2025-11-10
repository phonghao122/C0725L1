package ss11.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryConversion {
    public static void main(String[] args) {
        System.out.println("Nhap so can chuyen: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> list = new Stack<>();
        while (n != 0){
            list.add(n%2);
            n /= 2;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
