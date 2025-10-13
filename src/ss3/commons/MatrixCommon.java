package ss3.commons;

import java.util.Scanner;

public class MatrixCommon {
    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Nhập n: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Nhập lại n: ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Nhập lại n: ");
            }
        } while (true);

        int m = 0;
        do {
            System.out.println("Nhập m: ");
            try {
                m = sc.nextInt();
                if (m <= 0) {
                    System.out.println("Nhập lại m: ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Nhập lại m: ");
            }
        } while (true);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Nhập phần tử thứ [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return matrix;
    }

    public static void printMatrix ( int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double findMaxValue(int[][] matrix) {
        double max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]>max){
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static int sumColumnMatrix(int[][] matrix) {
        Scanner sc = new Scanner(System.in);
        int k = 0;
        System.out.println("Nhập cột cần tính tổng: ");
        do {
            k = sc.nextInt();
            if (k < 0 || k >= matrix[0].length) {
                System.out.println("Nhập lại: ");
            }
        } while (k < 0 || k >= matrix[0].length);
        sc.close();
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == k) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumDiagonalMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == i) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }
}
