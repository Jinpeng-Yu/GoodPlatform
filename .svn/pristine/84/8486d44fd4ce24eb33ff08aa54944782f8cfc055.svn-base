package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    Province findProvinceByProvinceId(String provinceId);

    Province findProvinceByName(String name);

    @Query(value = "select new com.hitwh.shop.model.entity.Province(p.id,p.name,p.provinceId) from Province p")
    List<Province> getProvince();
}
