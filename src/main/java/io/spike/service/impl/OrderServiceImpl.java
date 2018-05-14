package io.spike.service.impl;

import io.spike.domain.Order;
import io.spike.mapper.OrderMapper;
import io.spike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> listOrdersByUserId(Long userId) {
        return orderMapper.listOrdersByUserId(userId);
    }
}
