package com.hitwh.shop.model.pojo;

import java.sql.Timestamp;
import java.util.Map;

public class CommentColumn {
    private Integer commentId;
    private Integer skuId;
    private Integer grade;
    private String content;
    private Timestamp date;

    private Integer spuId;

    private Integer userId;
    private String username;
    private String headImg;

    private Map<String,String> attribute;

    public CommentColumn(Integer commentId, Integer skuId, Integer grade, String content, Timestamp date, Integer spuId, Integer userId, String username, String headImg, Map<String,String> attribute) {
        this.commentId = commentId;
        this.skuId = skuId;
        this.grade = grade;
        this.content = content;
        this.date = date;
        this.spuId = spuId;
        this.userId = userId;
        this.username = username;
        this.headImg = headImg;
        this.attribute = attribute;
    }

    public CommentColumn() {

    }

    @Override
    public String toString() {
        return "CommentColumn{" +
                "commentId=" + commentId +
                ", skuId=" + skuId +
                ", grade=" + grade +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", spuId=" + spuId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", headImg='" + headImg + '\'' +
                ", attribute='" + attribute + '\'' +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Map<String,String> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String,String> attribute) {
        this.attribute = attribute;
    }
}
