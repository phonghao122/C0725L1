package ss2.servicers;

import ss2.commons.PrimeCommon;

public class DisplayPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("Các SNT nhỏ hơn 100:");
        for (int i = 2; i < 100; i++) {
            if(PrimeCommon.checkPrime(i)){
                System.out.print(i + "\t");
            }
        }
    }


}
