package com.hitwh.shop.model.pojo;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class AddSpuResult {
    private String goodsName;
    private double goodsPrice;
    private Integer goodsNumber;
    private Integer goodsCat;
    private String picture;
    private String goodsIntroduce;
    private String attrName;
    private List<String> attrValues;

    public AddSpuResult() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGoodsCat() {
        return goodsCat;
    }

    public void setGoodsCat(Integer goodsCat) {
        this.goodsCat = goodsCat;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<String> getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(List<String> attrValues) {
        this.attrValues = attrValues;
    }

    @Override
    public String toString() {
        return "AddSpuResult{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsNumber=" + goodsNumber +
                ", goodsCat=" + goodsCat +
                ", picture='" + picture + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", attrName='" + attrName + '\'' +
                ", attrValues=" + attrValues +
                '}';
    }
}
