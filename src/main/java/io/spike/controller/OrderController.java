package io.spike.controller;

import io.spike.domain.Order;
import io.spike.domain.Result;
import io.spike.dto.BuyInfo;
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

    @GetMapping("/orders/{userId}/{goodsId}")
    public Result getOrderIdByUserIdAndGoodsId(@PathVariable("userId") Long userId, @PathVariable("goodsId") Long goodsId) {
        Long orderId = orderService.getOrderIdByUserIdAndGoodsId(userId, goodsId);
        return new Result<>(StateEnum.SUCCESS, orderId);
    }

    @PostMapping(value = "/orders", consumes = "application/json;charset=utf-8")
    public Result buyGoods(@RequestBody BuyInfo buyInfo) {
        int count = orderService.buyGoods(buyInfo.getUserId(), buyInfo.getGoodsId(), buyInfo.getPrice());
        if (count == 2) {
            return new Result<>(StateEnum.SUCCESS, "count: " + count);
        } else {
            return new Result<>(StateEnum.FAIL, "购买失败");
        }
    }

    @PostMapping(value = "/orders/successful", consumes = "application/json;charset=utf-8")
    public Result successTrade(@RequestBody String orderId) {
        int count = orderService.successTrade(Long.parseLong(orderId.trim()));
        if (count == 2) {
            return new Result<>(StateEnum.SUCCESS, "count: " + count);
        } else {
            return new Result<>(StateEnum.FAIL, "更新交易状态失败，count: " + count);
        }
    }

    @PostMapping(value = "/orders/cancel", consumes = "application/json;charset=utf-8")
    public Result cancelTrade(@RequestBody String orderId) {
        int count = orderService.cancelTrade(Long.parseLong(orderId.trim()));
        if (count == 2) {
            return new Result<>(StateEnum.SUCCESS, "count: " + count);
        } else {
            return new Result<>(StateEnum.FAIL, "更新交易状态失败，count: " + count);
        }
    }

}
