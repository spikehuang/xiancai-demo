package io.spike.mapper;

import io.spike.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> listOrdersByUserId(Long userId);
}
