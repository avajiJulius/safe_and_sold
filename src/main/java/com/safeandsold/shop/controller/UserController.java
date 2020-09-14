package com.safeandsold.shop.controller;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.exception.UserNotFoundException;
import com.safeandsold.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewManagerHomePage(@RequestParam(required = false) String filter, Model model) throws UserNotFoundException {
        List<User> userList = new ArrayList<>();
        if(filter != null && !filter.isEmpty()) {
            User userById = userService.getUserById(Long.parseLong(filter));
            userList.add(userById);
        } else {
            userList = userService.getAllUsers();
        }
        model.addAttribute("userList", userList);
        model.addAttribute("filter", filter);
        return "manager/main";
    }
}
