package ss2;

public class DisplayPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("Các SNT nhỏ hơn 100:");
        for (int i = 2; i < 100; i++) {
            if(checkPrime(i)){
                System.out.print(i + "\t");
            }
        }
    }

    public static boolean checkPrime(int n){
        if(n <= 1)
            return false;
        else{
            for (int i = 2;i<=Math.sqrt(n);i++){
                if(n%i==0)
                    return false;
            }
            return true;
        }
    }
}
