package com.safeandsold.shop.controller;

import com.safeandsold.shop.service.ProductService;
import com.safeandsold.shop.service.user.GuestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final ProductService productService;

    @Autowired
    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(name = "/")
    public String home(Model model) {
        model.addAttribute("productList", productService.findAllProduct());
        return "home";
    }

}
