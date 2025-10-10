package ss2;

public class DisplayPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("Các SNT nhỏ hơn 100:");
        for (int i = 2; i < 100; i++) {
            if(Display20Prime.checkPrime(i)){
                System.out.print(i + "\t");
            }
        }
    }


}
