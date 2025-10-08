package ss3;
import java.util.Scanner;

public class SumMainDiagonalToMatrix {
    public static void main(String[] args) {
        System.out.println("Nhập n: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Nhập lại: ");
            }
        } while (n <= 0);
        System.out.println("Nhập m: ");
        int m = 0;
        do {
            m = sc.nextInt();
            if (m <= 0 || m != n) {
                System.out.println("Nhập lại: ");
            }
        } while (m <= 0);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Nhập phần tử thứ [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == i) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        System.out.println("Sum: " + sum);
    }
}
