package io.spike.controller;

import io.spike.domain.Goods;
import io.spike.domain.Result;
import io.spike.enums.StateEnum;
import io.spike.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public Result listGoods() {
        List<Goods> goods = goodsService.listGoods();
        return new Result(StateEnum.SUCCESS, goods);
    }

    @PostMapping(value = "/goods", consumes = "application/json;charset=utf-8")
    public Result saveGoods(@RequestBody Goods goods) {
        int insertCount = goodsService.saveGoods(goods);
        return new Result(StateEnum.SUCCESS, insertCount);
    }

    @GetMapping("/user/{userId}/goods")
    public Result listGoodsByUserId(@PathVariable("userId") Long userId) {
        List<Goods> goods = goodsService.listGoodsByUserId(userId);
        return new Result(StateEnum.SUCCESS, goods);
    }

    @DeleteMapping("/goods/{goodsId}")
    public Result removeGoodsById(@PathVariable("goodsId") Long goodsId) {
        int deleteCount = goodsService.removeGoodsById(goodsId);
        return new Result(StateEnum.SUCCESS, deleteCount);
    }

    @GetMapping("/goods/{goodsId}")
    public Result getGoodsById(@PathVariable("goodsId") Long goodsId) {
        Goods goods = goodsService.getGoodsById(goodsId);
        return new Result(StateEnum.SUCCESS, goods);
    }
}