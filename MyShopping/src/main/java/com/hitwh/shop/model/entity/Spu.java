package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Spu
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/2 15:33
 * @Version 1.0
 **/
@Entity
public class Spu {
    private Integer id;
    private Integer spuTypeId;
    private Integer storeId;
    private String name;
    private String img;
    private Timestamp date;
    private String description;
    private Integer state;
    private Integer deleted;

    public Spu() {
    }

    public Spu(Integer id, Integer spuTypeId, Integer storeId, String name, String img, Timestamp date, String description, Integer state, Integer deleted) {
        this.id = id;
        this.spuTypeId = spuTypeId;
        this.storeId = storeId;
        this.name = name;
        this.img = img;
        this.date = date;
        this.description = description;
        this.state = state;
        this.deleted = deleted;
    }

    public Spu(Integer id, Integer spuTypeId, Integer storeId, String name, String img, Date date, String description, Integer state, Integer deleted) {
        this.id = id;
        this.spuTypeId = spuTypeId;
        this.storeId = storeId;
        this.name = name;
        this.img = img;
        this.date = new Timestamp(date.getTime());
        this.description = description;
        this.state = state;
        this.deleted = deleted;
    }

    public Spu(Integer spuTypeId, Integer storeId, String name, String img, String description) {
        this.spuTypeId = spuTypeId;
        this.storeId = storeId;
        this.name = name;
        this.img = img;
        this.description = description;
        this.date = new Timestamp(System.currentTimeMillis());
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
    @Column(name = "spu_type_id")
    public Integer getSpuTypeId() {
        return spuTypeId;
    }

    public void setSpuTypeId(Integer spuTypeId) {
        this.spuTypeId = spuTypeId;
    }

    @Basic
    @Column(name = "store_id")
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Spu spu = (Spu) o;
        return Objects.equals(id, spu.id) &&
                Objects.equals(spuTypeId, spu.spuTypeId) &&
                Objects.equals(storeId, spu.storeId) &&
                Objects.equals(name, spu.name) &&
                Objects.equals(img, spu.img) &&
                Objects.equals(date, spu.date) &&
                Objects.equals(description, spu.description) &&
                Objects.equals(state, spu.state) &&
                Objects.equals(deleted, spu.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuTypeId, storeId, name, img, date, description, state, deleted);
    }
}
