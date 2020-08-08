package com.hitwh.shop.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName County
 * @Description TODO
 * @Author 孙一恒
 * @Date 2020/6/8 16:51
 * @Version 1.0
 **/
@Entity
public class County {
    private Integer id;
    private String name;
    private String countyId;
    private String cityId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "county_id", nullable = true, length = 12)
    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    @Basic
    @Column(name = "city_id", nullable = true, length = 12)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        County county = (County) o;
        return Objects.equals(id, county.id) &&
                Objects.equals(name, county.name) &&
                Objects.equals(countyId, county.countyId) &&
                Objects.equals(cityId, county.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countyId, cityId);
    }
}
