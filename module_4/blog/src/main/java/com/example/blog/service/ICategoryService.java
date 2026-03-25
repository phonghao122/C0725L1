package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean deleteById(int id);
    boolean save(Category category);
    boolean update(Category category);
}
