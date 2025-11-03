package MVC.controller;

import MVC.entity.Student;
import MVC.service.IStudentService;
import MVC.service.StudentService;

import java.util.List;

public class StudentController {

    private final IStudentService studentService;

    public StudentController(){
        this.studentService = new StudentService();
    }

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public void save(Student student) {
        if (!studentService.checkId(student.getId())) {
            studentService.save(student);
        }
    }
    public void update(Student student) {
        if (studentService.checkId(student.getId())) {
            studentService.update(student);
        }
    }
    public void delete(int id) {
        if(studentService.checkId(id)){
            studentService.delete(id);
            System.out.println("Successfully deleted student");
        }
    }
    public Student findStudentById(int id) {
        if(studentService.checkId(id)){
            return studentService.findById(id);
        }
        return null;
    }

    public boolean checkId(int id) {
        return studentService.checkId(id);
    }
}
