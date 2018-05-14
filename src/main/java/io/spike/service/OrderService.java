package io.spike.service;

import io.spike.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> listOrdersByUserId(Long userId);
}
