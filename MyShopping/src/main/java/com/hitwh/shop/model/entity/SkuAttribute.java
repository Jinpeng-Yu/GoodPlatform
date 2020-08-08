package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName SkuAttribute
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
@Table(name = "sku_attribute", schema = "my_shopping", catalog = "")
public class SkuAttribute {
    private Integer id;
    private Integer skuId;
    private Integer attributeId;
    private Integer state;
    private Integer deleted;

    public SkuAttribute() {
    }

    public SkuAttribute(Integer id, Integer skuId, Integer attributeId, Integer state, Integer deleted) {
        this.id = id;
        this.skuId = skuId;
        this.attributeId = attributeId;
        this.state = state;
        this.deleted = deleted;
    }

    public SkuAttribute(Integer skuId, Integer attributeId) {
        this.skuId = skuId;
        this.attributeId = attributeId;
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
    @Column(name = "sku_id")
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "attribute_id")
    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
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
        SkuAttribute that = (SkuAttribute) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(skuId, that.skuId) &&
                Objects.equals(attributeId, that.attributeId) &&
                Objects.equals(state, that.state) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuId, attributeId, state, deleted);
    }
}
