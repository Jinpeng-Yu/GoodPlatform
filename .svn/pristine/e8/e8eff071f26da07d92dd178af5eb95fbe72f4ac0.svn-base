package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName Attribute
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/1 18:16
 * @Version 1.0
 **/
@Entity
public class Attribute {
    private Integer id;
    private Integer attributeTypeId;
    private String name;
    private Integer state;
    private Integer deleted;

    public Attribute(){

    }

    public Attribute(Integer id, Integer attributeTypeId, String name, Integer state, Integer deleted) {
        this.id = id;
        this.attributeTypeId = attributeTypeId;
        this.name = name;
        this.state = state;
        this.deleted = deleted;
    }

    public Attribute(Integer attributeTypeId, String name) {
        this.attributeTypeId = attributeTypeId;
        this.name = name;
        this.state = 0;
        this.deleted = 0;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", attributeTypeId=" + attributeTypeId +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", deleted=" + deleted +
                '}';
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
    @Column(name = "attribute_type_id")
    public Integer getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Integer attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id) &&
                Objects.equals(attributeTypeId, attribute.attributeTypeId) &&
                Objects.equals(name, attribute.name) &&
                Objects.equals(state, attribute.state) &&
                Objects.equals(deleted, attribute.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attributeTypeId, name, state, deleted);
    }
}
