package Case_Study.common;


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

    public static boolean checkPrice(String price) throws Exception {
        try {
            if (price != null) {
                if (checkDouble(price)) {
                    double priceDouble = Double.parseDouble(price);
                    if (priceDouble >= 0 &&  priceDouble <= 50000000) {
                        return true;
                    }else {
                        throw new Exception("Nhập lại giá");
                    }
                }else {
                    throw new Exception("Nhập lại giá");
                }
            }else {
                throw new Exception("Nhập lại giá");
            }
        }catch (Exception e){
            throw new Exception("Nhập lại giá");
        }
    }

    public static boolean checkQuantity(String quantity) throws Exception {
        try {
            if (quantity != null) {
                if (checkInteger(quantity)) {
                    int quantityInt = Integer.parseInt(quantity);
                    if (quantityInt >= 0 && quantityInt <= 100) {
                        return true;
                    }else {
                        throw new Exception("Nhập lại số lượng");
                    }
                }else {
                    throw new Exception("Nhập lại số lượng");
                }
            }else {
                throw new Exception("Nhập lại số lượng");
            }
        }catch (Exception e){
            throw new Exception("Nhập lại số lượng");
        }
    }
    public static boolean checkId(String id) throws Exception {
        try {
            if (checkInteger(id)) {
                int idInt = Integer.parseInt(id);
                if (idInt >= 0) {
                    return true;
                }else {
                    throw new Exception("Nhập lại id: ");
                }
            }else {
                throw new Exception("Nhập lại id: ");
            }
        } catch (Exception e) {
            throw new Exception("Nhập lại id: ");
        }
    }
}
