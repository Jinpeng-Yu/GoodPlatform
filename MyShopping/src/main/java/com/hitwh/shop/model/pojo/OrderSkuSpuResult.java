package com.hitwh.shop.model.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class OrderSkuSpuResult {
    private Integer orderid;
    private Integer skuId;
    private String SpuName;
    private Integer amount;
    private BigDecimal price;
    private Date Date;

    public OrderSkuSpuResult(Integer orderid, String spuName, Integer amount, BigDecimal price, Date date,Integer skuId) {
        this.orderid = orderid;
        this.SpuName = spuName;
        this.amount = amount;
        this.price = price;
        this.Date = date;
        this.skuId = skuId;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getSpuName() {
        return SpuName;
    }

    public void setSpuName(String spuName) {
        SpuName = spuName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
}
