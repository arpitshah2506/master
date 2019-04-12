package com.sterlite.controller;

import com.sterlite.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping(value = "/displayUser", method = RequestMethod.GET)
    public String displayUser() {
        return "displayUser";
    }

    @RequestMapping(value = "/submitUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User submitUser(@RequestBody User user) {
        return user;
    }
}
