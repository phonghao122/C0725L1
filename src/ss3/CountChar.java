package ss3;

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
    }
}
