package com.hitwh.shop.model.pojo;

/**
 * @ClassName SpuTypeExpenseResult
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/10 21:29
 * @Version 1.0
 **/
public class SpuTypeExpenseResult {
    private Integer spuTpeId;
    private String spuTypeName;
    private Double expense;

    public SpuTypeExpenseResult(Integer spuTpeId, String spuTypeName, Double expense) {
        this.spuTpeId = spuTpeId;
        this.spuTypeName = spuTypeName;
        this.expense = expense;
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

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
