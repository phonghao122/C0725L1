package ss3;

import java.util.Scanner;

public class SumColToMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Nhập n: ");
            try {
                n = sc.nextInt();
                if(n <= 0){
                    System.out.println("Nhập lại n: ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Nhập lại n: ");
            }
        }while(true);

        int m = 0;
        do {
            System.out.println("Nhập m: ");
            try {
                m = sc.nextInt();
                if(m <= 0){
                    System.out.println("Nhập lại m: ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Nhập lại m: ");
            }
        }while(true);

        int[][] matrix = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.println("Nhập phần tử thứ ["+i+"]["+j+"]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        int k = 0;
        System.out.println("Nhập cột cần tính tổng: ");
        do {
            k = sc.nextInt();
            if (k < 0 || k >= n) {
                System.out.println("Nhập lại: ");
            }
        } while (k < 0 || k >= n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == k) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        System.out.println("Sum: " + sum);
    }
}
