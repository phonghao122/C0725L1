package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping("")
    public String home(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/add")
    public String add(){
        return "student/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") int id,
                      @RequestParam("name") String name,
                      @RequestParam("age") int age,
                      @RequestParam("gender") String gender,
                      RedirectAttributes redirectAttributes){
        studentService.save(new Student(id, name, age, gender));
        redirectAttributes.addFlashAttribute("mess", "Student added successfully!");
        return "redirect:/student";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Student deleted successfully!");
        return "redirect:/student";
    }
}
