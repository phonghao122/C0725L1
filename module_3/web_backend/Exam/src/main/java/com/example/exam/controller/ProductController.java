package com.example.exam.controller;


import com.example.exam.dto.ProductDto;
import com.example.exam.entity.Category;
import com.example.exam.entity.Product;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ICategoryService;
import com.example.exam.service.IProductService;
import com.example.exam.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "productController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }

        switch (action) {
            case "addProduct":
                handleAdd(req, resp);
                break;
            case "search":

                break;
            default:
                showList(req, resp);
        }
    }

    private void handleEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product       = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        req.setAttribute("product",    product);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/view/admin/product/edit.jsp").forward(req, resp);
    }

    private void handleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/view/admin/product/add.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> all = productService.findAll();
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        List<ProductDto> products = new ArrayList<>();
        for (Product product : all) {
            String categoryName = categoryService.findById(product.getCategoryId()).getName();
            products.add(new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getColor(), product.getCategoryId(), categoryName));

        }
        req.setAttribute("products",   products);

        req.getRequestDispatcher("/view/product/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "addProduct":
                doAddProduct(req, resp);
                break;
            case "delete":
                doDeleteProduct(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void doDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String deleteIdParam = req.getParameter("id");
        if (deleteIdParam == null || deleteIdParam.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/product");
            return;
        }
        int deleteId = Integer.parseInt(deleteIdParam);
        productService.deleteById(deleteId);
        String mess = "Đã xóa thành công";
        resp.sendRedirect(req.getContextPath() + "/product?mess="+(mess));
    }

    private void doAddProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name        = req.getParameter("name");
        double price       = Double.parseDouble(req.getParameter("price"));
        int quantity       = Integer.parseInt(req.getParameter("quantity"));
        String color      = req.getParameter("color");
        int categoryId     = Integer.parseInt(req.getParameter("category_id"));

        Product product = new Product(name,price,quantity,color,categoryId);
        boolean success = productService.save(product);
        if (success){
            String mess = "Đã thêm thành công";
            resp.sendRedirect(req.getContextPath() + "/product?mess="+(mess));
        }
    }
}
