package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
public class Comment {
    private Integer id;
    private Integer skuId;
    private Integer userId;
    private Integer grade;
    private String content;
    private Timestamp date;
    private Integer state;
    private Integer deleted;

    public Comment() {

    }

    public Comment(Integer id, Integer skuId, Integer userId, Integer grade, String content, Date date, Integer state, Integer deleted) {
        this.id = id;
        this.skuId = skuId;
        this.userId = userId;
        this.grade = grade;
        this.content = content;
        this.date = new Timestamp(date.getTime());
        this.state = state;
        this.deleted = deleted;
    }

    public Comment(Integer skuId, Integer userId, Integer grade, String content, Date date, Integer state, Integer deleted) {
        this.skuId = skuId;
        this.userId = userId;
        this.grade = grade;
        this.content = content;
        this.date = new Timestamp(date.getTime());
        this.state = state;
        this.deleted = deleted;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sku_id")
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "deleted")
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(skuId, comment.skuId) &&
                Objects.equals(userId, comment.userId) &&
                Objects.equals(grade, comment.grade) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(date, comment.date) &&
                Objects.equals(state, comment.state) &&
                Objects.equals(deleted, comment.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuId, userId, grade, content, date, state, deleted);
    }
}
