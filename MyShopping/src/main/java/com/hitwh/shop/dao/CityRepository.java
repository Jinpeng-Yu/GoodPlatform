package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByCityId(String cityId);

    City findCityByName(String name);

    List<City> findCityByProvinceId(String provinceId);
}
