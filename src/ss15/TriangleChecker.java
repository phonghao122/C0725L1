package ss15;


public class TriangleChecker {
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh tam giác phải lớn hơn 0.");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }

        System.out.println("Tam giác hợp lệ!");
    }

}
