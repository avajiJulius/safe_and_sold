package com.safeandsold.shop.controller;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.service.ProductService;
import com.safeandsold.shop.service.manager.ManagerProductService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ManagerProductService productService;

    @Autowired
    public ProductController(ManagerProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProductHome(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";

    }

    @PostMapping("/saveProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);

        return "redirect:/";
    }
}
