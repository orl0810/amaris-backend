package com.amaris.amaris.controllers;

import com.amaris.amaris.models.UserModel;
import com.amaris.amaris.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    @ResponseBody
    public List<UserModel> getUsers() {
        return this.userService.getUsersFromUrl();
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public UserModel getUsers(@PathVariable("id") int id) {
        return this.userService.getUserFromUrl(id);
    }
}
