package com.safeandsold.shop.controller;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.exception.UserNotFoundException;
import com.safeandsold.shop.service.manager.ManagerUserService;
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

    private final ManagerUserService userService;

    @Autowired
    public UserController(ManagerUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewManagerHomePage(@RequestParam(name = "id", required = false) String id,
                                      @RequestParam(name = "filter", required = false) String filter,
                                      Model model) throws UserNotFoundException {
        List<User> userList = userService.findAllUsers();
        if(id != null && !id.isEmpty()) {
            User userById = userService.findById(Long.parseLong(id));
            userList.add(userById);
        } else if (filter != null && !filter.isEmpty()){
            userList = userService.findByUsername(filter);
        }
        model.addAttribute("userList", userList);
        model.addAttribute("id", id);
        model.addAttribute("filter", filter);
        return "manager/main";
    }
}
