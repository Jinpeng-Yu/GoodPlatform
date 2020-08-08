package com.hitwh.shop.model.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.Date;

public class SellerOrderResult {
    private Integer orderId;
    private Integer userId;
    private Integer addressId;
    private Integer orderNumber;
    private Integer orderState;
    private Date orderDate;
    private String goodName;

    public SellerOrderResult(Integer orderId, Integer userId, Integer addressId, Integer orderNumber, Integer orderState, Date orderDate, String goodName) {
        this.orderId = orderId;
        this.userId = userId;
        this.addressId = addressId;
        this.orderNumber = orderNumber;
        this.orderState = orderState;
        this.orderDate = orderDate;
        this.goodName = goodName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Override
    public String toString() {
        return "SellerOrderResult{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderDate=" + orderDate +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
