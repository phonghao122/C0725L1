package ss2;

import java.util.Scanner;

public class AddElementToArray {
    public static void  main(String args[]) {
        int[] n = {1,3,4,7,6,3,0,0,0};
        System.out.println("Nhập phần tử cần chèn: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Nhập vị trí muốn chèn: ");
        int add_index = sc.nextInt();
        if(add_index < 0 || add_index >= n.length) {
            System.out.println("Không thể chèn");
        }else {
            for(int i = n.length - 1; i > add_index; i--){
                n[i] = n[i - 1];
            }
            n[add_index] = x;
            for (int i = 0;i<n.length;i++){
                System.out.print(n[i] + "\t");
            }
        }
    }
}
