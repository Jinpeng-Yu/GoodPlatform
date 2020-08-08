package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Attribute;
import com.hitwh.shop.model.entity.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 苏嘉尧
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

    Attribute findAttributeById(Integer attributeId);

    @Query(value = "select new com.hitwh.shop.model.entity.Attribute(a.id, a.attributeTypeId,a.name,a.state,a.deleted) from Attribute a where a.attributeTypeId = :attributeTypeId and a.deleted = 0")
    List<Attribute> findAttributesByAttributeTypeId(@Param("attributeTypeId") Integer attributeTypeId);

    @Query(value = "select new com.hitwh.shop.model.entity.AttributeType(at.id, at.spuId,at.name,at.state,at.deleted) from AttributeType at where at.spuId = :spuId and at.deleted = 0")
    List<AttributeType> findAttributeTypesBySpuId(@Param("spuId") Integer spuId);

    @Query(value = "select new com.hitwh.shop.model.entity.Attribute(a.id, a.attributeTypeId,a.name,a.state,a.deleted) from Attribute a,SkuAttribute sa " +
            "where sa.skuId = :skuId and sa.attributeId = a.id and a.attributeTypeId = :attributeTypeId and a.deleted = 0 and sa.deleted = 0")
    Attribute findAttributeBySkuIdAndAttributeTypeId(@Param("skuId") Integer skuId, @Param("attributeTypeId") Integer attributeTypeId) ;
}
