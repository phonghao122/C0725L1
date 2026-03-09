package com.example.ss2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String home() {
        return "/sandwich/home";
    }

    @PostMapping("/sandwich")
    public String sandwich(@RequestParam("condiment") List<String> condiments,
                           RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("condiments", condiments);
        return "redirect:/sandwich";
    }
}
