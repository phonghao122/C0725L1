package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String getAddCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String postAddCategory(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category added successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String getEditCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String postEditCategory(Category category, RedirectAttributes redirectAttributes){
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("message", "Category updated successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteCategory(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Category deleted successfully");
        redirectAttributes.addFlashAttribute("type", "success");
        return "redirect:/category";
    }
}
