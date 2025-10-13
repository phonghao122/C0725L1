package ss2.commons;

public class PrimeCommon {
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
