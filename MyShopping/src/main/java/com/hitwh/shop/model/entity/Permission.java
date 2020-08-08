package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
public class Permission {
    private Integer id;
    private String urlPrefix;
    private Integer state;
    private Integer deleted;

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
    @Column(name = "url_prefix")
    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
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
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(urlPrefix, that.urlPrefix) &&
                Objects.equals(state, that.state) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urlPrefix, state, deleted);
    }
}
