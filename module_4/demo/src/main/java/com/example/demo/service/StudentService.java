package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService implements IStudentService{
    private List<Student> students = new ArrayList<>();
    public StudentService(){
        students.add(new Student(1, "John", 20, "Male"));
        students.add(new Student(2, "Jane", 21, "Female"));
    }
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void delete(int id) {
        Student student = findById(id);
        students.remove(student);
    }

    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(student.getId() == id)
                return student;
        }
        return null;
    }
}
