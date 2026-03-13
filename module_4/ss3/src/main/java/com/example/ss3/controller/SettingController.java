package com.example.ss3.controller;

import com.example.ss3.entity.Setting;
import com.example.ss3.service.ISettingService;
import com.example.ss3.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {
    @Autowired
    private ISettingService settingService;

    @ModelAttribute("languages")
    public String[] languages() {
        String[] languages = {"English", "Spanish", "French", "Vietnamese"};
        return languages;
    }

     @ModelAttribute("pageSizes")
     public int[] pageSizes() {
        int[] pageSizes = {5, 10, 20, 50};
         return pageSizes;
     }

    @GetMapping("/settings")
    public String home(Model model) {
        if (!model.containsAttribute("settings")) {
            model.addAttribute("settings", new Setting());
        }
        return "/setting/home";
    }

    @PostMapping("/settings")
    public String save(@ModelAttribute("settings") Setting settings,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("settings", settings);
        redirectAttributes.addFlashAttribute("message", "Update successful");
        return "redirect:/settings";
    }
}
