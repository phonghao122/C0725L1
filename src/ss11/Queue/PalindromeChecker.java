package ss11.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("✅ Chuỗi \"" + input + "\" là Palindrome!");
        } else {
            System.out.println("❌ Chuỗi \"" + input + "\" KHÔNG phải là Palindrome!");
        }

        sc.close();
    }

    // -------------------------------------------------
    // Hàm kiểm tra Palindrome sử dụng Queue và Stack
    // -------------------------------------------------
    public static boolean isPalindrome(String str) {
        // Loại bỏ khoảng trắng và chuyển về chữ thường
        str = str.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Thêm các ký tự vào Queue và Stack
        for (char c : str.toCharArray()) {
            queue.add(c);   // hàng đợi (FIFO)
            stack.push(c);  // ngăn xếp (LIFO)
        }

        // So sánh từng ký tự
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;  // nếu khác → không phải palindrome
            }
        }

        return true;
    }
}

