package com.hitwh.shop.model.pojo;

import com.hitwh.shop.model.entity.Attribute;
import com.hitwh.shop.model.entity.Sku;

import java.util.Map;
import java.util.List;

public class SPUResultForBuyer {
    private Integer spuId;
    private String name;
    private String img;
    private String description;
    private Integer storeId;
    private String storeDescription;
    //第一个参数String为attribute_type_name,
    private Map<String , List<Attribute>> attributeList;
    private List<SkuResult> skuResultList;

    public SPUResultForBuyer() {

    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Map<String, List<Attribute>> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(Map<String, List<Attribute>> attributeList) {
        this.attributeList = attributeList;
    }

    public List<SkuResult> getSkuResultList() {
        return skuResultList;
    }

    public void setSkuResultList(List<SkuResult> skuResultList) {
        this.skuResultList = skuResultList;
    }

    @Override
    public String toString() {
        return "SPUResultForBuyer{" +
                "spuId=" + spuId +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", storeId=" + storeId +
                ", storeDescription='" + storeDescription + '\'' +
                ", attributeList=" + attributeList +
                ", skuResultList=" + skuResultList +
                '}';
    }
}
