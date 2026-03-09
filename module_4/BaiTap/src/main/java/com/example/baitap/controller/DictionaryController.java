package com.example.baitap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String home() {
        return "/dictionary/home";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam("word") String word,
                             RedirectAttributes redirectAttributes) {
        List<String> english = new ArrayList<>();
        List<String> vietnamese = new ArrayList<>();

        english.add("hello");
        vietnamese.add("xin chào");

        english.add("book");
        vietnamese.add("quyển sách");

        english.add("computer");
        vietnamese.add("máy tính");

        english.add("student");
        vietnamese.add("sinh viên");

        english.add("teacher");
        vietnamese.add("giáo viên");

        String result = "Không tìm thấy";

        int index = english.indexOf(word.toLowerCase());

        if (index != -1) {
            result = vietnamese.get(index);
        }
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("word", word);
        return "redirect:/dictionary";
    }
}
