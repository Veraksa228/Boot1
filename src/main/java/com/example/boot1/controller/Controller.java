package com.example.boot1.controller;

import com.example.boot1.model.User;
import com.example.boot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";

    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/remove")
    public String removeUser(@RequestParam("userId") Long id, Model model) {
        User user = userService.findUser(id);
        userService.removeUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("userId") Long userId, Model model) {
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}


