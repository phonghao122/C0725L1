package com.example.blog.rest_controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogs = blogService.getBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PostMapping("")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
        Category category = categoryService
                .findById(blog.getCategory().getId());

        blog.setCategory(category);

        blogService.saveBlog(blog);

        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id){
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){
        Blog blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }
}
