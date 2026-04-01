package com.example.ss8.controller;

import com.example.ss8.dto.UserDto;
import com.example.ss8.entity.User;
import com.example.ss8.service.IUserService;
import com.example.ss8.validation.UserValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private IUserService userService;
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/add")
    public String register(
            @Valid @ModelAttribute("user") UserDto user,
            BindingResult result,
            RedirectAttributes ra
    ) {
        new UserValidation().validate(user,result);
        if (result.hasErrors()){
            return "register";
        }

        userService.save(user);

        ra.addFlashAttribute("message", "Register success!");
        ra.addFlashAttribute("type", "success");

        return "redirect:/register/add";
    }
}
