package com.hitwh.shop.model.pojo;

/**
 * @ClassName SpuSalesResult
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/8 21:06
 * @Version 1.0
 **/
public class SpuSalesResult {
    private Integer spuId;
    private String spuName;
    private Long sales;

    public SpuSalesResult(Integer spuId, String spuName, Long sales) {
        this.spuId = spuId;
        this.spuName = spuName;
        this.sales = sales;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }
}
