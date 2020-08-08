package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 孙一恒
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findUserRoleByUserId(Integer userId);
}
