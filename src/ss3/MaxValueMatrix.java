package ss3;

import java.util.Scanner;

public class MaxValueMatrix {
    public static void main(String[] args) {
        int[][] matrix;
        System.out.println("Nhập n: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            n = sc.nextInt();
            if(n <= 0){
                System.out.println("Nhập lại: ");
            }
        }while(n <= 0);
        System.out.println("Nhập m: ");
        int m = 0;
        do {
            m = sc.nextInt();
            if(m <= 0){
                System.out.println("Nhập lại: ");
            }
        }while(m <= 0);
        matrix = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.println("Nhập phần tử thứ ["+i+"]["+j+"]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        int max = matrix[0][0];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]>max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max: " + max);
    }
}
