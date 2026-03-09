package com.example.baitap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConvertController {
    @GetMapping("/home")
    public String home() {
        return "/convert/home";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") int usd,
                          @RequestParam("rate") double rate,
                          RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("result", usd*rate);
        return "redirect:/home";
    }
}
