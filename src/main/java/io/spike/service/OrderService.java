package io.spike.service;

import io.spike.domain.Goods;
import io.spike.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    List<Order> listOrdersByUserId(Long userId);

    Order getOrderById(Long orderId);

    Long getOrderIdByUserIdAndGoodsId(Long userId, Long goodsId);

    int buyGoods(Long userId, Long goodsId, BigDecimal price);
}
