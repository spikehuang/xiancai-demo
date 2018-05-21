package io.spike.controller;

import io.spike.domain.Goods;
import io.spike.domain.Result;
import io.spike.enums.StateEnum;
import io.spike.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebPageController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String index() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @GetMapping("/goods/{goodsId}/detail")
    public String goodsDetail(@PathVariable("goodsId") Long goodsId, Model model) {
        Goods goods = goodsService.getGoodsById(goodsId);
        Result result = new Result<>(StateEnum.SUCCESS, goods);
        model.addAttribute("result", result);
        return "/goods";
    }

}
