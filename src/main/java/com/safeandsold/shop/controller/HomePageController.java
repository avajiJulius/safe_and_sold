package com.safeandsold.shop.controller;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.exception.ProductNotFoundException;
import com.safeandsold.shop.service.ProductService;
import com.safeandsold.shop.service.user.GuestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomePageController {

    private final ProductService productService;

    @Autowired
    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(name = "/")
    public String home(
            @RequestParam(name = "minPrice", required = false) Integer min,
            @RequestParam(name = "maxPrice", required = false) Integer max,
            @RequestParam(name = "productName", required = false) String productName,
            Model model) throws ProductNotFoundException {

        List<Product> productList = productService.findAllProduct();
        if(min != null && max != null) {
            productList = productService.findByPrice(min, max);
        }
        if(productName != null && !productName.isEmpty()) {
            productList = productService.findByProductName(productName);
        }

        model.addAttribute("productList", productList);
        model.addAttribute("productName", productName);
        model.addAttribute("minPrice", min);
        model.addAttribute("maxPrice", max);
        return "home";
    }

}
