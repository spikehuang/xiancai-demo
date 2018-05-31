package io.spike.service.impl;

import io.spike.domain.Order;
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
    public List<Order> listOrdersByUserId(Long userId) {
        return orderMapper.listOrdersByUserId(userId);
    }

    @Override
    public int buyGoods(Long userId, Long goodsId, BigDecimal price) {
        int count = orderMapper.saveOrder(userId, goodsId, price);
        count += goodsMapper.updateStatusById(goodsId, 1);
        return count;
    }

}
