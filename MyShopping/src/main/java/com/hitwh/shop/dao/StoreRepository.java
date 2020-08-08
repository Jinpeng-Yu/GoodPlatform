package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 苏嘉尧
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById(Integer storeId);

    Store findStoreByUserId(Integer userId);
}
