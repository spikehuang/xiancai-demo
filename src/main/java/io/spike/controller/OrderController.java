package io.spike.controller;

import io.spike.domain.Order;
import io.spike.domain.Result;
import io.spike.enums.StateEnum;
import io.spike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/user/{userId}")
    public Result listOrdersByUserId(@PathVariable("userId") Long userId) {
        List<Order> orders = orderService.listOrdersByUserId(userId);
        return new Result<>(StateEnum.SUCCESS, orders);
    }

    @PostMapping(value = "/orders", consumes = "application/json;charset=utf-8")
    public Result buyGoods(@RequestBody Object requestInfo) {

        return null;
    }

}
