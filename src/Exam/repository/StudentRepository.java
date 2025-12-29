package Exam.repository;

import Case_Study.entity.BankAccount;
import Exam.entity.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final String FILE_PATH = "src/Exam/data/students.csv";
    private final List<Student> students;

    public StudentRepository() throws Exception {
        students = new ArrayList<>();
        loadFromFile();
    }


    private void loadFromFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean isFirst = true;

            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) continue;

                int id = Integer.parseInt(data[0]);
                String name = data[1].trim();
                String dob = data[2].trim();
                String gender = data[3].trim();
                String phone = data[4].trim();
                int classId = Integer.parseInt(data[5].trim());
                students.add(new Student(id, name,dob,gender,phone,classId));
            }

        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,name,dob,gender,phone,class_id");
                bw.newLine();
            } catch (IOException ex) {
                throw new Exception("Lỗi ghi file");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("id,name,dob,gender,phone,class_id");
            bw.newLine();

            for (Student std : students) {
                bw.write(std.getId() + "," +
                        std.getName() + "," +
                        std.getDob() + "," +
                        std.getGender()+ "," +
                        std.getPhone()+ "," +
                        std.getClassID());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file");
        }
    }

    public  List<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
        for (Student std : students) {
            if (std.getId() == id) return std;
        }
        return null;
    }

    public boolean saveStudent(Student std) throws Exception {
        if (std == null) return false;
        students.add(std);
        saveToFile();
        return true;
    }

    public void deleteStudent(int id) throws Exception {
        for (Student std : students) {
            if (std.getId() == id){
                students.remove(std);
                saveToFile();
                break;
            }
        }

    }

    public List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        for (Student std : students) {
            if (name.contains(std.getName())) return studentList;
        }
        return null;
    }

    public Student findByPhone(String phone) {
        for (Student std : students) {
            if (std.getPhone().equals(phone)) return std;
        }
        return null;
    }
}
