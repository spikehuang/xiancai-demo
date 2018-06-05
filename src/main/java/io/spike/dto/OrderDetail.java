package io.spike.dto;

import java.math.BigDecimal;

public class OrderDetail {

    private Long orderId;

    private String name;

    private BigDecimal money;

    private String status;

    private String username;

    private String phone;

    private String createTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", money=" + money +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
