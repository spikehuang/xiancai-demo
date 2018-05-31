package io.spike.mapper;

import io.spike.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> listOrdersByUserId(Long userId);

    int saveOrder(@Param("userId") Long userId, @Param("goodsId") Long goodsId, @Param("price") BigDecimal price);
}
