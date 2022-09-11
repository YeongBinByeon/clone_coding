package com.dipractice.controller;

import com.dipractice.annotation.Controller;
import com.dipractice.annotation.Inject;
import com.dipractice.service.UserService;

@Controller
public class UserController {

    private final UserService userService;


    @Inject
    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
