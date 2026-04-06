package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    boolean saveBlog(Blog blog);
    Blog getBlogById(int id);
    boolean deleteBlog(int id);
    boolean updateBlog(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> searchBlog(String keyword, Pageable pageable);
    Page<Blog> searchBlogByCategory(int categoryId, Pageable pageable);
    Page<Blog> searchByTitleAndCategory(String keyword, int categoryId, Pageable pageable);
    List<Blog> getBlogs();
}
