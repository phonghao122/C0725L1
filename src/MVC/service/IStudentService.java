package MVC.service;

import MVC.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    void save(Student student);

    void update(Student student);

    void delete(int id);

    Student findById(int id);

    boolean checkId(int id);
}
