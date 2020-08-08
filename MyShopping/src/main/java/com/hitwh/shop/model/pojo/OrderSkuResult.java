package com.hitwh.shop.model.pojo;

public class OrderSkuResult {
    private Integer id;
    private Integer orderId;
    private Integer skuId;
    private Integer number;
    private Integer state;
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }


    public OrderSkuResult( Integer skuId, Integer number, Integer orderId) {
        this.skuId = skuId;
        this.number = number;
        this.orderId = orderId;
        this.deleted = 0;
        this.state = 0;

    }
}
