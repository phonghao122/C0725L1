package ss3.services;

import java.util.Arrays;

public class CountChar {
    public static void main(String args[]) {
        String str = "Advanced Programming with Java 2.1";
        char c = 'a';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println(count);

        String[] a = {"Jonh", "Mary", "Caly", "Tomy"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
