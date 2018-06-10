package io.spike.controller;

import io.spike.domain.*;
import io.spike.dto.OrderDetail;
import io.spike.enums.StateEnum;
import io.spike.mapper.OrderMapper;
import io.spike.service.GoodsCatService;
import io.spike.service.GoodsService;
import io.spike.service.OrderService;
import io.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebPageController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCatService goodsCatService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<Goods> goods = goodsService.listGoods();
        Result result = new Result<>(StateEnum.SUCCESS, goods);
        List<GoodsCat> goodsCats = goodsCatService.listGoodsCats();
        Result cats = new Result<>(StateEnum.SUCCESS, goodsCats);
        model.addAttribute("result", result);
        model.addAttribute("cats", cats);
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

    @GetMapping("/publish")
    public String publish() {
        return "/publish";
    }

    @GetMapping("/user-center/{userId}")
    public String person(@PathVariable("userId") Long userId, Model model) {
        User user = userService.getUserById(userId);
        Result result = new Result<>(StateEnum.SUCCESS, user);
        model.addAttribute("result", result);
        return "/person";
    }

    @GetMapping("/orders/{orderId}/detail")
    public String showOrderDetail(@PathVariable("orderId") Long orderId, Model model) {
        OrderDetail orderDetail = orderService.getOrderDetailById(orderId);
        Result result = new Result<>(StateEnum.SUCCESS, orderDetail);
        model.addAttribute("result", result);
        return "/order";
    }

    @GetMapping("/administrator")
    public String administrator(Model model) {
        model.addAttribute("userResult", new Result<>(StateEnum.SUCCESS, userService.listUsers()));
        model.addAttribute("goodsResult", new Result<>(StateEnum.SUCCESS, goodsService.listAllGoods()));
        model.addAttribute("goodsCatResult", new Result<>(StateEnum.SUCCESS, goodsCatService.listGoodsCats()));
        return "/administrator";
    }

    @GetMapping("/orders/user/{userId}")
    public String listOrders(@PathVariable("userId") Long userId, Model model) {
        List<OrderDetail> orders = orderService.listOrdersWithGoodsNameByUserId(userId);
        Result result = new Result<>(StateEnum.SUCCESS, orders);
        model.addAttribute("result", result);
        return "/order-list";
    }

}
