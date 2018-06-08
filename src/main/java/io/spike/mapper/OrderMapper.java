package io.spike.mapper;

import io.spike.domain.Order;
import io.spike.dto.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> listOrdersByUserId(Long userId);

    Order getOrderById(Long orderId);

    Long getOrderIdByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    int saveOrder(@Param("userId") Long userId, @Param("goodsId") Long goodsId, @Param("money") BigDecimal money);

    OrderDetail getOrderDetailById(Long orderId);

    int updateStatusById(@Param("orderId") Long orderId, @Param("status") Integer status);

    Long getGoodsIdByOrderId(Long orderId);

    List<OrderDetail> listOrdersWithGoodsNameByUserId(Long userId);
}
