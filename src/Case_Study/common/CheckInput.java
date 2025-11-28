package Case_Study.common;


import Case_Study.service.BankAccountService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static boolean checkInteger(String input) throws Exception {
        try {
            long num = Long.parseLong(input);
            if (num < Integer.MAX_VALUE){
                return true;
            }else {
                throw new Exception("Số quá lớn");
            }
        } catch (Exception e) {
            throw new Exception("Nhập sai định dạng");
        }
    }
    public static boolean checkDouble(String input) throws Exception {
        try {
            double num = Double.parseDouble(input);
            if (num < Double.MAX_VALUE){
                return true;
            }else {
                throw new Exception("Số quá lớn");
            }
        }catch (Exception e) {
            throw new Exception("Nhập sai định dạng");
        }
    }
    public static boolean checkString(String input) throws Exception {
        try {
            return !input.isEmpty();
        }catch (Exception e) {
            throw new Exception("Nhập sai định dạng");
        }
    }
    public static boolean checkName(String name) throws Exception {
        try {
            String regex = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưỮỰÝỲỴỶỸ]"
                    + "[a-zàáâãèéêìíòóôõùúăđĩũơưạảấầẩẫậắằẳẵặẹẻẽềềểưữựýỳỵỷỹ]+"
                    + "(?: [A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưỮỰÝỲỴỶỸ]"
                    + "[a-zàáâãèéêìíòóôõùúăđĩũơưạảấầẩẫậắằẳẵặẹẻẽềềểưữựýỳỵỷỹ]+)*$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            if (name.length() < 50 && checkString(name) && matcher.matches()){
                return true;
            }else {
                throw new Exception("Nhập lại tên");
            }
        }catch (Exception e) {
            throw new Exception("Nhập lại tên");
        }
    }
    public static boolean checkEmail(String email) throws Exception {
        try {
            String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                return true;
            }else {
                throw new Exception("Nhập lại email");
            }
        }catch (Exception e) {
            throw new Exception("Nhập lại email");
        }
    }

    public static boolean checkAccountNumber(String accountNumber) throws Exception {
        if(accountNumber == null){
            throw new Exception("Nhập lại số tài khoản");
        }
        if (!accountNumber.matches("^(03|05|07|08|09)\\d{8}$")) {
            throw new Exception("Nhập lại số tài khoản");
        }
        return true;
    }

    public static boolean checkPIN(String pin) throws Exception {
        if (pin == null) {
            throw new Exception("Nhập lại PIN: ");
        }
        if(!pin.matches("^\\d{6}$")){
            throw new Exception("Nhập lại PIN: ");
        }
        return true;
    }

    public static boolean checkAmount(String amount) throws Exception {
        if(checkDouble(amount)){
            double dobleAmount = Double.parseDouble(amount);
            if (dobleAmount < 50000 || dobleAmount > 10000000) {
                throw new Exception("Nhập lại số tiền: ");
            }
            if (dobleAmount%50000 != 0){
                throw new Exception("Số tiền phải là bội số của 50.000 VND");
            }
            return true;
        }
        return false;
    }
}
