package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName Store
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
public class Store {
    private Integer id;
    private Integer userId;
    private String description;
    private Integer state;
    private Integer deleted;

    public Store() {
    }

    public Store(Integer userId, String description, Integer state, Integer deleted) {
        this.userId = userId;
        this.description = description;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Store store = (Store) o;
        return Objects.equals(id, store.id) &&
                Objects.equals(userId, store.userId) &&
                Objects.equals(description, store.description) &&
                Objects.equals(state, store.state) &&
                Objects.equals(deleted, store.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, description, state, deleted);
    }
}
