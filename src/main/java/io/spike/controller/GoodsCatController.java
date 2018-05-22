package io.spike.controller;

import io.spike.domain.GoodsCat;
import io.spike.domain.Result;
import io.spike.enums.StateEnum;
import io.spike.service.GoodsCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsCatController {

    @Autowired
    private GoodsCatService goodsCatService;

    @GetMapping("/goodsCat")
    public Result listGoodsCats() {
        List<GoodsCat> goodsCats = goodsCatService.listGoodsCats();
        return new Result<>(StateEnum.SUCCESS, goodsCats);
    }
}
