package ss11.Stack;

import java.util.List;
import java.util.Stack;

public class ReverseArray {
    public static  void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
