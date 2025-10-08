package ss2;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] n = {1,2,6,5,8,4};
        System.out.println("Nhập phần tử cần xóa: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int index_del = 0;
        boolean check = false;
        for (int i = 0; i < n.length; i++) {
            if(n[i] == x){
                index_del = i;
                check = true;
            }
        }
        if(!check){
            System.out.println("Phần tử không tồn tại trong mảng");
        }else {
            for(int i = index_del; i < n.length; i++){
                if(i == n.length - 1){
                    n[i] = 0;
                }else {
                    n[i] = n[i + 1];
                }
            }
            for (int i = 0;i < n.length;i++){
                System.out.print(n[i] + "\t");
            }
        }
    }
}
