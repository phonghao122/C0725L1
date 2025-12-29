package Exam.common;


import Exam.repository.ClassRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            if (name.length() < 50 && checkString(name) && matcher.matches() && name.length() > 3) {
                return true;
            }else {
                throw new Exception("Nhập lại tên");
            }
        }catch (Exception e) {
            throw new Exception("Nhập lại tên");
        }
    }

    public static boolean checkPhone(String phone) throws Exception {
        if(phone == null){
            throw new Exception("Nhập lại số điện thoại");
        }
        if (!phone.matches("^(03|05|07|08|09)\\d{8}$")) {
            throw new Exception("Nhập lại số điện thoại");
        }
        return true;
    }

    public static boolean checkDate(String date) throws Exception {
        if (date == null || date.trim().isEmpty()) {
            throw new Exception("Nhập lại ngày");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (Exception e) {
            throw new Exception("Nhập lại ngày đúng định dạng dd/MM/yyyy");
        }
    }

    public static boolean checkGender(String gender) throws Exception {
        if(gender == null){
            throw new Exception("Nhập lại giới tính");
        }
        if (gender.equals("M") ||  gender.equals("F")) {
            return true;
        }else {
            throw new Exception("Nhập lại đúng giới tính (M/F)");
        }
    }

    public static boolean checkClassId(String classId) throws Exception {
        if(classId == null){
            throw new Exception("Nhập lại classId");
        }
        int id = Integer.parseInt(classId);
        ClassRepository  classRepository = new ClassRepository();
        if (classRepository.getClassById(id) != null) {
            return true;
        }else {
            throw new Exception("Class không tồn tại");
        }
    }
}
