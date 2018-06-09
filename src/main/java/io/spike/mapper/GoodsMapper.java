package io.spike.mapper;

import io.spike.domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    List<Goods> listGoods();

    List<Goods> listAllGoods();

    int saveGoods(Goods goods);

    List<Goods> listGoodsByUserId(Long userId);

    int removeGoodsById(Long goodsId);

    Goods getGoodsById(Long goodsId);

    List<Goods> listGoodsByCat(Integer catId);

    List<Goods> listGoodsByName(@Param("name") String name);

    int updateStatusById(@Param("goodsId") Long goodsId, @Param("status") Integer status);
}
