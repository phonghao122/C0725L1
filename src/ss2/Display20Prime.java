package ss2;

import java.util.Scanner;

public class Display20Prime {
    public static void main(String[] args) {
        System.out.println("Cần hiển thị bao nhiêu SNT: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            n = sc.nextInt();
            if(n <= 0){
                System.out.println("Nhập lại n: ");
            }
        }while (n <= 0);
        int count = 0;
        int num = 2;
        while (count < n){
            if(checkPrime(num)){
                count++;
                System.out.print(num + "\t");
            }
            num++;
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
