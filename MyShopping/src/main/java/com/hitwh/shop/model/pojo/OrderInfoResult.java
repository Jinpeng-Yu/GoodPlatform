package com.hitwh.shop.model.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class OrderInfoResult {
    private Integer orderId;
    private String spuName;
    private Integer goodNumber;
    private Date orderDate;

    public OrderInfoResult(Integer orderId, String spuName, Integer goodNumber, Date orderDate) {
        this.orderId = orderId;
        this.spuName = spuName;
        this.goodNumber = goodNumber;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderInfoResult{" +
                "orderId=" + orderId +
                ", spuName='" + spuName + '\'' +
                ", goodNumber=" + goodNumber +
                ", orderDate=" + orderDate +
                '}';
    }
}
