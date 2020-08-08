package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.SpuType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpuTypeRepository extends JpaRepository<SpuType, Integer> {
    List<SpuType> findSpuTypesByDeleted(Integer deleted);
}
