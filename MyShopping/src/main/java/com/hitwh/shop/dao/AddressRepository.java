package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressByUserId(Integer userId);

    @Query(value = "select a from Address a, Order o where o.id = :orderId and a.id = o.addressId ")
    Address findAddressByOrderId(Integer orderId);
}
