package io.spike.mapper;

import io.spike.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    List<Goods> listGoods();

    int saveGoods(Goods goods);

    List<Goods> listGoodsByUserId(Long userId);

    int removeGoodsById(Long goodsId);

    Goods getGoodsById(Long goodsId);
}
