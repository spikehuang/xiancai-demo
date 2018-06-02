package io.spike.controller;

import io.spike.domain.Result;
import io.spike.domain.User;
import io.spike.enums.StateEnum;
import io.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{phone}/{password}")
    public Result login(@PathVariable("phone") String phone, @PathVariable("password") String password, HttpServletResponse response) {
        User currentUser = userService.getUserByPhone(phone);
        if (currentUser != null) {
            if (password.equals(currentUser.getPassword())) {
                Cookie usernameCookie = new Cookie("username", currentUser.getUsername());
                Cookie userIdCookie = new Cookie("userId", currentUser.getUserId().toString());
                usernameCookie.setMaxAge(60 * 60 * 24 * 7); // 保留7天
                usernameCookie.setPath("/xiancai");
                userIdCookie.setMaxAge(60 * 60 * 24 * 7);
                userIdCookie.setPath("/xiancai");
                response.addCookie(usernameCookie);
                response.addCookie(userIdCookie);
                return new Result<>(StateEnum.SUCCESS, currentUser);
            }
            return new Result<>(StateEnum.FAIL, "密码错误");
        }
        return new Result<>(StateEnum.FAIL, "用户不存在");
    }

    @PostMapping(value = "/user", consumes = "application/json;charset=utf-8")
    public Result saveUser(@RequestBody User user) {
        Result<String> result;
        try {
            userService.saveUser(user);
            result = new Result<>(StateEnum.SUCCESS, "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result<>(StateEnum.FAIL, "注册失败");
        }
        return result;
    }

    @GetMapping("/user/{phone}")
    public boolean isExist(@PathVariable("phone") String phone) {
        User currentUser = userService.getUserByPhone(phone);
        return currentUser != null;
    }
}
