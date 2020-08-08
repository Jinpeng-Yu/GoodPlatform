package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName AttributeType
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
@Table(name = "attribute_type", schema = "my_shopping", catalog = "")
public class AttributeType {
    private Integer id;
    private Integer spuId;
    private String name;
    private Integer state;
    private Integer deleted;

    public AttributeType(){}

    public AttributeType(Integer id, Integer spuId, String name, Integer state, Integer deleted) {
        this.id = id;
        this.spuId = spuId;
        this.name = name;
        this.state = state;
        this.deleted = deleted;
    }

    public AttributeType(Integer spuId, String name) {
        this.spuId = spuId;
        this.name = name;
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
    @Column(name = "spu_id")
    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        AttributeType that = (AttributeType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(spuId, that.spuId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(state, that.state) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuId, name, state, deleted);
    }
}
