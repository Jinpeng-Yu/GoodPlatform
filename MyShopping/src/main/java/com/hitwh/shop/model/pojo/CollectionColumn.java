package com.hitwh.shop.model.pojo;

import java.sql.Timestamp;

/**
 * @ClassName CollectionColumn
 * @Description TODO
 * @Author 苏嘉尧
 * @Date 2019/6/14 19:34
 * @Version 1.0
 **/

//收藏夹的一列
public class CollectionColumn {
    private Integer id;
    private Integer userId;

    private Integer spuId;
    private Integer storeId;
    private String storeDescription;
    private String name;
    private String img;

    private Timestamp date;
    private Integer state;
    private Integer deleted;

    public CollectionColumn(Integer id, Integer userId, Integer spuId, Integer storeId, String storeDescription, String name, String img, Timestamp date, Integer state, Integer deleted) {
        this.id = id;
        this.userId = userId;
        this.spuId = spuId;
        this.storeId = storeId;
        this.storeDescription = storeDescription;
        this.name = name;
        this.img = img;
        this.date = date;
        this.state = state;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "CollectionColumn{" +
                "id=" + id +
                ", userId=" + userId +
                ", spuId=" + spuId +
                ", storeId=" + storeId +
                ", storeDescription='" + storeDescription + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", deleted=" + deleted +
                '}';
    }
}

