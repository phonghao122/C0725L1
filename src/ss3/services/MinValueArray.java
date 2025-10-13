package ss3.services;

import java.util.Scanner;

public class MinValueArray {
    public static   void main(String args[]){
        System.out.println("Nhập số lượng phần tử: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            try {
                n = sc.nextInt();
                if (n<=0){
                    System.out.println("Nhập lại: ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Nhập lại: ");
            }
        }while (true);
        int[] arr = new int[n];
        for (int i = 0; i<arr.length;i++){
            System.out.println("Nhập phần tử thứ "+ (i+1));
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        int min = arr[0];
        for (int i = 1; i<arr.length;i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("Min: " + min);

    }
}
