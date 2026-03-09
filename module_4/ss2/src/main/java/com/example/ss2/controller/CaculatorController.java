package com.example.ss2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CaculatorController {
    @GetMapping("/calculator")
    public String home() {
        return "/calculator/home";
    }

    @PostMapping("/calculator")
    public String caculator(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operator") String operator,
                            RedirectAttributes redirectAttributes) {
        double result = 0;
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    redirectAttributes.addFlashAttribute("error", "Cannot divide by zero");
                    return "redirect:/calculator";
                }
                break;
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/calculator";
    }
}
