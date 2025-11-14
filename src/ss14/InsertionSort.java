package ss14;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Bước " + i + ": Chèn phần tử " + key);

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;

                System.out.println("  Dời phần tử sang phải: " + Arrays.toString(arr));
            }

            arr[j + 1] = key;

            System.out.println("  ==> Mảng sau khi chèn " + key + ": " + Arrays.toString(arr) + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Nhập " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nMảng ban đầu: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("=== MẢNG SAU KHI SẮP XẾP: " + Arrays.toString(arr) + " ===");
    }
}
