package io.spike.dto;

import java.math.BigDecimal;

public class BuyInfo {

    private Long userId;

    private Long goodsId;

    private BigDecimal price;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BuyInfo{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                ", price=" + price +
                '}';
    }
}
