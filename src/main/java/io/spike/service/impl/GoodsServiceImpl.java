package io.spike.service.impl;

import io.spike.domain.Goods;
import io.spike.mapper.GoodsMapper;
import io.spike.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> listGoods() {
        return goodsMapper.listGoods();
    }

    @Override
    public int saveGoods(Goods goods) {
        return goodsMapper.saveGoods(goods);
    }

    @Override
    public List<Goods> listGoodsByUserId(Long userId) {
        return goodsMapper.listGoodsByUserId(userId);
    }

    @Override
    public int removeGoodsById(Long goodsId) {
        return goodsMapper.removeGoodsById(goodsId);
    }

    @Override
    public Goods getGoodsById(Long goodsId) {
        return goodsMapper.getGoodsById(goodsId);
    }

    @Override
    public List<Goods> listGoodsByCat(Integer catId) {
        return goodsMapper.listGoodsByCat(catId);
    }
}
