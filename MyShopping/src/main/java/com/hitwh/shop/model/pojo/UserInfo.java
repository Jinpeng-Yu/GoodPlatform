package com.hitwh.shop.model.pojo;

public class UserInfo {
    private String headImg;
    private String username;
    private String email;
    private String provinceName;
    private String cityName;
    private String countryName;
    private String detail;
    private String phone;
    private String password;

    public UserInfo() {
    }

    public UserInfo(String headImg, String username, String email, String provinceName, String cityName, String countryName, String detail, String phone, String password) {
        this.headImg = headImg;
        this.username = username;
        this.email = email;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.countryName = countryName;
        this.detail = detail;
        this.phone = phone;
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
