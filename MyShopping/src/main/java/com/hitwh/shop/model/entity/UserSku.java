package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName UserSku
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
@Table(name = "user_sku", schema = "my_shopping", catalog = "")
public class UserSku {
    private Integer id;
    private Integer userId;
    private Integer skuId;
    private Integer number;
    private Integer state;
    private Integer deleted;

    public UserSku(){

    }
    public UserSku(Integer userId, Integer skuId, Integer number, Integer state, Integer deleted) {
        this.userId = userId;
        this.skuId = skuId;
        this.number = number;
        this.state = state;
        this.deleted = deleted;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        UserSku userSku = (UserSku) o;
        return Objects.equals(id, userSku.id) &&
                Objects.equals(userId, userSku.userId) &&
                Objects.equals(skuId, userSku.skuId) &&
                Objects.equals(number, userSku.number) &&
                Objects.equals(state, userSku.state) &&
                Objects.equals(deleted, userSku.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, skuId, number, state, deleted);
    }
}
