package io.spike.service.impl;

import io.spike.domain.Order;
import io.spike.dto.OrderDetail;
import io.spike.mapper.GoodsMapper;
import io.spike.mapper.OrderMapper;
import io.spike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrderDetail> listOrdersWithGoodsNameByUserId(Long userId) {
        return orderMapper.listOrdersWithGoodsNameByUserId(userId);
    }

    @Override
    public Long getOrderIdByUserIdAndGoodsId(Long userId, Long goodsId) {
        return orderMapper.getOrderIdByUserIdAndGoodsId(userId, goodsId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public int buyGoods(Long userId, Long goodsId, BigDecimal price) {
        int count = orderMapper.saveOrder(userId, goodsId, price);
        count += goodsMapper.updateStatusById(goodsId, 1);
        return count;
    }

    @Override
    public OrderDetail getOrderDetailById(Long orderId) {
        return orderMapper.getOrderDetailById(orderId);
    }

    @Override
    public int successTrade(Long orderId) {
        Long goodsId = orderMapper.getGoodsIdByOrderId(orderId);
        int count = goodsMapper.updateStatusById(goodsId, 2);
        count += orderMapper.updateStatusById(orderId, 1);
        return count;
    }

    @Override
    public int cancelTrade(Long orderId) {
        Long goodsId = orderMapper.getGoodsIdByOrderId(orderId);
        int count = goodsMapper.updateStatusById(goodsId, 0);
        count += orderMapper.updateStatusById(orderId, 2);
        return count;
    }

}
