package Exam.view;

import Exam.common.CheckInput;
import Exam.entity.Student;
import Exam.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void studentView() {
        try {
            StudentRepository studentRepository = new StudentRepository();
            Scanner sc = new Scanner(System.in);
            int option;
            do {
                System.out.println("\n--- STUDENT VIEW ---");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Xóa sinh viên");
                System.out.println("3. Danh sách sinh viên");
                System.out.println("4. Tìm kiếm sinh viên");
                System.out.println("0. Quay lại menu chính");
                System.out.print("👉 Chọn: ");

                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("➡️ Thêm sinh viên...");
                        try {
                            String name, dob, gender, phone, classId;
                            do {
                                try {
                                    System.out.print("Nhập tên: ");
                                    name = sc.nextLine();
                                    CheckInput.checkName(name);
                                    break;
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            do {
                                try {
                                    System.out.print("Nhập ngày sinh: ");
                                    dob = sc.nextLine();
                                    CheckInput.checkDate(dob);
                                    break;
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            do {
                                try {
                                    System.out.print("Nhập giới tính: ");
                                    gender = sc.nextLine();
                                    CheckInput.checkGender(gender);
                                    break;
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            do {
                                try {
                                    System.out.print("Nhập số điện thoại: ");
                                    phone = sc.nextLine();
                                    CheckInput.checkPhone(phone);
                                    break;
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            do {
                                try {
                                    System.out.print("Nhập mã lớp học: ");
                                    classId = sc.nextLine();
                                    break;
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }while (true);
                            studentRepository.saveStudent(new Student(name, dob, gender, phone, Integer.parseInt(classId)));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("➡️ Xóa sinh viên...");
                        do {
                            try {
                                System.out.print("Nhập id: ");
                                String id = sc.nextLine();
                                if(studentRepository.getStudent(Integer.parseInt(id))!=null) {
                                    studentRepository.deleteStudent(Integer.parseInt(id));
                                    System.out.println("Xóa thành công");
                                }
                                break;
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }while (true);
                        break;
                    case 3:
                        System.out.println("➡️ Danh sách sinh viên...");
                        if(!studentRepository.getStudents().isEmpty()) {
                            displayStudents(studentRepository.getStudents());
                        }else {
                            System.out.println("Chưa có sinh viên");
                        }
                        break;
                    case 4:
                        System.out.println("➡️ Tìm kiếm sinh viên...");
                        System.out.print("Nhập tên cần tìm: ");
                        String name = sc.nextLine();
                        if(studentRepository.findByName(name)!=null) {
                            displayStudents(studentRepository.findByName(name));
                        }else {
                            System.out.println("Không tìm thấy");
                        }
                        break;
                    case 0:
                        System.out.println("↩️ Quay lại menu chính...");
                        break;
                    default:
                        System.out.println("⚠️ Lựa chọn không hợp lệ!");
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void displayStudent(Student student) {
        System.out.println("id: " + student.getId()+
                "\nname: "+ student.getName()+
                "\ndob: "+ student.getDob()+
                "\ngender: "+ student.getGender()+
                "\nphone: "+ student.getPhone()+
                "\nclassID: "+student.getClassID());
    }

    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            displayStudent(student);
        }
    }
}
