package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/home")
    public String home(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "sort", required = false) String sort,
            Model model) {
        Sort sortObj = Sort.unsorted();
        if ("title_asc".equals(sort)) {
            sortObj = Sort.by("title").ascending();
        } else if ("title_desc".equals(sort)) {
            sortObj = Sort.by("title").descending();
        } else if ("category_asc".equals(sort)) {
            sortObj = Sort.by("category.name").ascending();
        } else if ("category_desc".equals(sort)) {
            sortObj = Sort.by("category.name").descending();
        }
        Pageable pageable = PageRequest.of(page, 3, sortObj);
        Page<Blog> blogs;

        if ((keyword != null && !keyword.isEmpty()) && categoryId != null) {
            blogs = blogService.searchByTitleAndCategory(keyword, categoryId, pageable);
        } else if (keyword != null && !keyword.isEmpty()) {
            blogs = blogService.searchBlog(keyword, pageable);
        } else if (categoryId != null) {
            blogs = blogService.searchBlogByCategory(categoryId, pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categoryService.findAll());

        // giữ lại giá trị đã chọn
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("sort", sort);

        return "blog/list";
    }

    @GetMapping("/add")
    public String getAddBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/add";
    }

    @PostMapping("/add")
    public String postAddBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Blog added successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/blog/home";
    }

    @GetMapping("/edit/{id}")
    public String getEditBlog(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String postEditBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/blog/home";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteBlog(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message", "Blog deleted successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/blog/home";
    }

    @GetMapping("/detail/{id}")
    public String getDetailBlog(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        return "blog/detail";
    }


}
