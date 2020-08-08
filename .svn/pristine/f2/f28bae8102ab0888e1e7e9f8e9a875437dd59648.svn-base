package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName SpuType
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
@Table(name = "spu_type", schema = "my_shopping", catalog = "")
public class SpuType {
    private Integer id;
    private String name;
    private Integer state;
    private Integer deleted;

    public SpuType() {
    }

    public SpuType(Integer id, String name, Integer state, Integer deleted) {
        this.id = id;
        this.name = name;
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
        SpuType spuType = (SpuType) o;
        return Objects.equals(id, spuType.id) &&
                Objects.equals(name, spuType.name) &&
                Objects.equals(state, spuType.state) &&
                Objects.equals(deleted, spuType.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, deleted);
    }
}
