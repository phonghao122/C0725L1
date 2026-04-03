package com.example.cart.controller;

import com.example.cart.entity.Cart;
import com.example.cart.entity.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String shop(Model model, @SessionAttribute(name = "cart", required = false) Cart cart) {

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart);
        model.addAttribute("products", productService.findAll());

        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message", "Product added to cart");
        return "redirect:/shop";
    }

    @PostMapping("/checkout")
    public String checkout(SessionStatus status, RedirectAttributes ra) {
        status.setComplete();

        ra.addFlashAttribute("message", "Thanh toán thành công!");
        ra.addFlashAttribute("type", "success");

        return "redirect:/shop";
    }

    @GetMapping("/clear-cart")
    public String clearCart(@SessionAttribute("cart") Cart cart,
                            RedirectAttributes ra) {

        cart.getProducts().clear();

        ra.addFlashAttribute("message", "Cart cleared!");
        ra.addFlashAttribute("type", "success");

        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id,
                         @SessionAttribute("cart") Cart cart,
                         RedirectAttributes ra) {

        Optional<Product> product = productService.findById(id);

        if (product != null) {
            cart.removeProduct(product.get());

            ra.addFlashAttribute("message", "Removed item!");
            ra.addFlashAttribute("type", "success");
        }

        return "redirect:/shopping-cart";
    }
}
