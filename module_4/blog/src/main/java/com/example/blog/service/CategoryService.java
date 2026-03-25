package com.example.blog.service;

import com.example.blog.entity.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Category category) {
        if (category != null){
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        if (category != null){
            categoryRepository.save(category);
            return true;
        }
        return false;
    }
}
