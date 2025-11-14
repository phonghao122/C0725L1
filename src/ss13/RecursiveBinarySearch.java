package ss13;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int x) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == x) {
            return mid;
        }

        if (x < arr[mid]) {
            return binarySearch(arr, left, mid - 1, x);
        }

        return binarySearch(arr, mid + 1, right, x);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 15, 20};
        int x = 7;

        int result = binarySearch(arr, 0, arr.length - 1, x);

        if (result != -1) {
            System.out.println("Tìm thấy " + x + " tại vị trí: " + result);
        } else {
            System.out.println("Không tìm thấy " + x + " trong mảng");
        }
    }
}
