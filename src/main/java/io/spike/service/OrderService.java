package io.spike.service;

import io.spike.domain.Goods;
import io.spike.domain.Order;
import io.spike.dto.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    List<OrderDetail> listOrdersWithGoodsNameByUserId(Long userId);

    Order getOrderById(Long orderId);

    Long getOrderIdByUserIdAndGoodsId(Long userId, Long goodsId);

    int buyGoods(Long userId, Long goodsId, BigDecimal price);

    OrderDetail getOrderDetailById(Long orderId);

    int successTrade(Long orderId);

    int cancelTrade(Long orderId);
}
