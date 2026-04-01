package com.example.ss8_song.controller;

import com.example.ss8_song.dto.SongDto;
import com.example.ss8_song.entity.Song;
import com.example.ss8_song.service.ISongService;
import com.example.ss8_song.validation.SongValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }

    // ===================== SHOW FORM ADD =====================
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new SongDto());
        model.addAttribute("id", null);
        return "song/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/song";
        }
        model.addAttribute("song", song);
        model.addAttribute("id", id);
        return "song/edit";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("song") SongDto song, BindingResult result, RedirectAttributes ra) {
        SongValidation validation = new SongValidation();
        validation.validate(song, result);
        if (result.hasErrors()) {

            return "song/add";
        }
        songService.save(song);
        ra.addFlashAttribute("message", "Added successfully!");
        ra.addFlashAttribute("type", "success");
        return "redirect:/song";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid @ModelAttribute("song") SongDto song,
                       BindingResult result,
                       RedirectAttributes ra,
                       @PathVariable("id") Integer id) {
        SongValidation validation = new SongValidation();
        validation.validate(song, result);
        if (result.hasErrors()) {
            return "song/edit";
        }
        songService.update(song, id);
        ra.addFlashAttribute("message", "Updated successfully!");
        ra.addFlashAttribute("type", "success");
        return "redirect:/song";
    }

    // ===================== DELETE =====================
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        songService.deleteByid(id);

        ra.addFlashAttribute("message", "Deleted successfully!");
        ra.addFlashAttribute("type", "success");

        return "redirect:/song";
    }
}
