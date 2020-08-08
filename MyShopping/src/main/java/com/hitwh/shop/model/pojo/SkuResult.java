package com.hitwh.shop.model.pojo;

import com.hitwh.shop.model.entity.Attribute;

import java.math.BigDecimal;
import java.util.Map;

public class SkuResult {
    private Integer skuId;
    private Integer spuId;
    private BigDecimal price;
    private Integer stock;

    private Map<String , Attribute> skuAttribute;

    public SkuResult(Integer skuId, Integer spuId, BigDecimal price, Integer stock, Map<String, Attribute> skuAttribute) {
        this.skuId = skuId;
        this.spuId = spuId;
        this.price = price;
        this.stock = stock;
        this.skuAttribute = skuAttribute;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Map<String, Attribute> getSkuAttribute() {
        return skuAttribute;
    }

    public void setSkuAttribute(Map<String, Attribute> skuAttribute) {
        this.skuAttribute = skuAttribute;
    }

    @Override
    public String toString() {
        return "SkuResult{" +
                "skuId=" + skuId +
                ", spuId=" + spuId +
                ", price=" + price +
                ", stock=" + stock +
                ", skuAttribute=" + skuAttribute +
                '}';
    }
}
