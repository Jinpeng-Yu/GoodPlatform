package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyRepository extends JpaRepository<County, Integer> {
    County findCountyByCountyId(String countyId);

    County findCountyByName(String name);

    List<County> findCountyByCityId(String cityId);
}
