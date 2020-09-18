package com.safeandsold.shop.controller;

import com.safeandsold.shop.domain.Role;
import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("usr", user);
        return "registration";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("usr") User user) {
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setExist(true);

        userService.saveUser(user);

        return "redirect:/login";
    }

}
