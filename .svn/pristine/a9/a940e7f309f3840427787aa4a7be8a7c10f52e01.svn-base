package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 苏嘉尧
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/

public interface CollectionRepository extends JpaRepository<Collection, Integer> {

    List<Collection> findCollectionsByUserId(Integer userId);

    Collection findCollectionBySpuIdAndUserId(Integer spuId, Integer userId);
}
