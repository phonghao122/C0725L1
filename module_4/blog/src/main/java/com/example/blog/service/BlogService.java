package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public boolean saveBlog(Blog blog) {
        if (blog != null){
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteBlog(int id) {
        if (blogRepository.existsById(id)){
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        if (blog != null){
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchBlog(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> searchBlogByCategory(int categoryId, Pageable pageable) {
        return blogRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Blog> searchByTitleAndCategory(String keyword, int categoryId, Pageable pageable) {
        return blogRepository.findByTitleContainingAndCategoryId(keyword, categoryId, pageable);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }
}
