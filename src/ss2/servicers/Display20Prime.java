package ss2.servicers;

import ss2.commons.PrimeCommon;

import java.util.Scanner;

public class Display20Prime {
    public static void main(String[] args) {
        System.out.println("Cần hiển thị bao nhiêu SNT: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            try{
                String a = sc.nextLine();
                n = Integer.parseInt(a);
                if(n <= 0){
                    System.out.println("Nhập lại n: ");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Nhập lại n");
            }
        }while (true);
        int count = 0;
        int num = 2;
        while (count < n){
            if(PrimeCommon.checkPrime(num)){
                count++;
                System.out.print(num + "\t");
            }
            num++;
        }
    }


}
