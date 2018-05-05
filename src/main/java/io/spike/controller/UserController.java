package io.spike.controller;

import io.spike.domain.User;
import io.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{phone}/{password}")
    public Object login(@PathVariable("phone") String phone, @PathVariable("password") String password) {
        User currentUser = userService.getUserByPhone(phone);
        if (currentUser != null) {
            if (password.equals(currentUser.getPassword())) {
                return currentUser;
            }
        }
        return null;
    }

    @PostMapping(value = "/user", consumes = "application/json;charset=utf-8")
    public int saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user/{phone}")
    public boolean isExist(@PathVariable("phone") String phone) {
        User currentUser = userService.getUserByPhone(phone);
        return currentUser != null;
    }
}
