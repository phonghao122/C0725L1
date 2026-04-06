package com.example.blog.rest_controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogs = blogService.getBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PostMapping("")
    public ResponseEntity<Blog> saveBlog(Blog blog){
        blogService.saveBlog(blog);
        return ResponseEntity.created(null).body(blog);
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
