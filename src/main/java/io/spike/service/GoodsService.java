package io.spike.service;

import io.spike.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> listGoods();

    int saveGoods(Goods goods);

    List<Goods> listGoodsByUserId(Long userId);

    int removeGoodsById(Long goodsId);

    Goods getGoodsById(Long goodsId);

    List<Goods> listGoodsByCat(Integer catId);
}
