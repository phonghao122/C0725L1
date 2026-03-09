package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int id);
    Student findById(int id);
}
