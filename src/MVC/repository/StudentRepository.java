package MVC.repository;

import MVC.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepository {

    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(2, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(3, "HaiTT", LocalDate.now(), 9.8f));
        students.add(new Student(4, "HaiTT", LocalDate.now(), 9.8f));
    }

    public List<Student> findAll() {
        return students;
    }
    public void save(Student student) {
        students.add(student);
    }
    public void update(Student student) {
        for (Student stud : students) {
            if (Objects.equals(stud.getId(), student.getId())) {
                stud.setName(student.getName());
                stud.setDob(student.getDob());
                stud.setScore(student.getScore());
            }
        }
    }

    public void delete(int id) {
        for (Student stud : students) {
            if (Objects.equals(stud.getId(), id)) {
                students.remove(stud);
            }
        }
    }

    public Student findById(int id) {
        for (Student stud : students) {
            if (Objects.equals(stud.getId(), id)) {
                return stud;
            }
        }
        return null;
    }

    public boolean checkId(int id) {
        for (Student stud : students) {
            if (Objects.equals(stud.getId(), id)) {
                return true;
            }
        }
        return false;
    }
}
