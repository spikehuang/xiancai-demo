package io.spike.service;

import io.spike.domain.Goods;
import io.spike.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    List<Order> listOrdersByUserId(Long userId);

    int buyGoods(Long userId, Long goodsId, BigDecimal price);
}
