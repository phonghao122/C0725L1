package ss12.common;

public class CheckInput {
    public static boolean checkInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

}
