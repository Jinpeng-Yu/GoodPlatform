package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.OrderSku;
import com.hitwh.shop.model.pojo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface OrderSkuRepository extends JpaRepository<OrderSku, Integer>{
    @Query(value = "select new com.hitwh.shop.model.entity.OrderSku(o.orderId,o.skuId,o.number) " +
            "from OrderSku o " +
            "where o.orderId = :orderId")
    OrderSku findbyOrderId(Integer orderId);

    @Transactional
    @Modifying
    @Query(value = "update OrderSku s set s.deleted = 1 where s.orderId = :orderId")
    void deleteOrderSkuById(Integer orderId);
}
