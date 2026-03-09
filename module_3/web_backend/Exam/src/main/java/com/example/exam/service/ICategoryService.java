package com.example.exam.service;

import com.example.exam.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean delete(int id);
    boolean update(Category category);
}
