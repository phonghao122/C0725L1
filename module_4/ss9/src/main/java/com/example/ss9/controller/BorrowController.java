package com.example.ss9.controller;

import com.example.ss9.service.IBookService;
import com.example.ss9.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BorrowController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    @GetMapping("/books")
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/book/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/detail";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam Integer bookId, RedirectAttributes ra) {
        try {
            String code = borrowService.borrowBook(bookId);

            ra.addFlashAttribute("message", "Mượn thành công!");
            ra.addFlashAttribute("type", "success");
            ra.addFlashAttribute("code", code);

            return "redirect:/success";

        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            ra.addFlashAttribute("type", "danger");
            return "redirect:/error";
        }
    }

    @GetMapping("/return")
    public String returnForm() {
        return "book/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, RedirectAttributes ra) {
        try {
            borrowService.returnBook(code);

            ra.addFlashAttribute("message", "Trả sách thành công!");
            ra.addFlashAttribute("type", "success");

            return "redirect:/books";

        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            ra.addFlashAttribute("type", "danger");

            return "redirect:/error";
        }
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
