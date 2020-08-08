package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName OrderSku
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
@Table(name = "order_sku", schema = "my_shopping", catalog = "")
public class OrderSku {
    private Integer id;
    private Integer orderId;
    private Integer skuId;
    private Integer number;
    private Integer state;
    private Integer deleted;


    public OrderSku(Integer orderId, Integer skuId, Integer number) {
        this.orderId = orderId;
        this.skuId = skuId;
        this.number = number;
        this.state = 0;
        this.deleted = 0;
    }
    public OrderSku() {
        this.state = 0;
        this.deleted = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "sku_id")
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "deleted")
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSku orderSku = (OrderSku) o;
        return Objects.equals(id, orderSku.id) &&
                Objects.equals(orderId, orderSku.orderId) &&
                Objects.equals(skuId, orderSku.skuId) &&
                Objects.equals(number, orderSku.number) &&
                Objects.equals(state, orderSku.state) &&
                Objects.equals(deleted, orderSku.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, skuId, number, state, deleted);
    }
}
