package MVC.view;

import MVC.controller.StudentController;
import MVC.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final StudentController studentController = new StudentController();

    public void view() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa");
            System.out.println("4. Sửa");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Student> students = studentController.findAll();
                    displayStudents(students);
                    break;
                case 2:
                    Student student = new Student();
                    student.setId(studentController.findAll().size());
                    System.out.println("Nhap ten: ");
                    student.setName(scanner.nextLine());
                    student.setDob(LocalDate.now());
                    System.out.println("Nhap diem: ");
                    student.setScore(Float.parseFloat(scanner.nextLine()));
                    studentController.save(student);
                    break;
                case 3:
                    System.out.println("Nhap id: ");
                    while (true) {
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            if (studentController.checkId(id)) {
                                studentController.delete(id);
                                break;
                            }
                        }catch (Exception e){
                            System.out.println("Nhap lai id: ");
                        }
                    }
                    break;
                case 4:
                    Student student1 = new Student();
                    System.out.println("Nhap id: ");
                    student1.setId(Integer.parseInt(scanner.nextLine()));
                    if(studentController.checkId(student1.getId())) {
                        System.out.println("Nhap ten: ");
                        student1.setName(scanner.nextLine());
                        student1.setDob(LocalDate.now());
                        System.out.println("Nhap diem: ");
                        student1.setScore(Float.parseFloat(scanner.nextLine()));
                        studentController.update(student1);
                    }else {
                        System.out.println("Student khong ton tai");
                    }
                    break;
                case 5:
                    System.out.println("Nhap id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if(studentController.checkId(id)) {
                        displayStudent(studentController.findStudentById(id));
                    }else {
                        System.out.println("Student khong ton tai");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    public void displayStudents(List<Student> students) {
        for (Student student : students) {
            displayStudent(student);
        }
    }

    public void displayStudent(Student student) {
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Dob: " + student.getDob());
        System.out.println("Score: " + student.getScore());
    }
}
