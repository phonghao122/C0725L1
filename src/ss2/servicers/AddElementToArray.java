package ss2.servicers;

import java.util.Scanner;

public class AddElementToArray {
    public static void  main(String args[]) {
        int[] n = {1,3,4,7,6,3,0,0,0};
        Scanner sc = new Scanner(System.in);
        int add_index = 0;
        int x = 0;
        do {
            try {
                System.out.println("Nhập phần tử cần chèn: ");
                String a = sc.nextLine();
                x = Integer.parseInt(a);
                System.out.println("Nhập vị trí muốn chèn: ");
                String b = sc.nextLine();
                add_index = Integer.parseInt(b);
                if(add_index >= n.length || add_index < 0) {
                    System.out.println("Nhập lại");
                    continue;
                }
                break;
            }catch (Exception e) {
                System.out.println("Nhập lại");
            }
        }while (true);
        for(int i = n.length - 1; i > add_index; i--){
            n[i] = n[i - 1];
        }
        n[add_index] = x;
        for (int i = 0;i<n.length;i++){
            System.out.print(n[i] + "\t");
        }
    }
}
