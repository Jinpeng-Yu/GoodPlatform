package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.UserSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserSkuRepository extends JpaRepository<UserSku, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update UserSku s set s.deleted = 1 where s.userId = :userId and s.skuId = :skuId")
    void deleteUserSkuBySkuIdAndUserId(Integer skuId,Integer userId);
}
