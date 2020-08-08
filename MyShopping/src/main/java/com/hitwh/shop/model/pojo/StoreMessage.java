package com.hitwh.shop.model.pojo;

public class StoreMessage {
    private Integer roleId;
    private String description;

    public StoreMessage(Integer roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

    public StoreMessage() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
