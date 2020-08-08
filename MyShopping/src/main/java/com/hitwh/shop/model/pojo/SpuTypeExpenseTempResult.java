package com.hitwh.shop.model.pojo;

import java.math.BigDecimal;

/**
 * @ClassName SpuTypeExpenseTempResult
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/10 22:55
 * @Version 1.0
 **/
public class SpuTypeExpenseTempResult {
    private Integer spuTpeId;
    private String spuTypeName;
    private BigDecimal price;
    private Integer number;

    public SpuTypeExpenseTempResult(Integer spuTpeId, String spuTypeName, BigDecimal price, Integer number) {
        this.spuTpeId = spuTpeId;
        this.spuTypeName = spuTypeName;
        this.price = price;
        this.number = number;
    }

    public Integer getSpuTpeId() {
        return spuTpeId;
    }

    public void setSpuTpeId(Integer spuTpeId) {
        this.spuTpeId = spuTpeId;
    }

    public String getSpuTypeName() {
        return spuTypeName;
    }

    public void setSpuTypeName(String spuTypeName) {
        this.spuTypeName = spuTypeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
