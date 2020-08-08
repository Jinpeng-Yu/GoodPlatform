package com.hitwh.shop.dao;

import com.hitwh.shop.model.entity.Permission;
import com.hitwh.shop.model.entity.Role;
import com.hitwh.shop.model.pojo.PermissionResult;
import com.hitwh.shop.model.pojo.RolePermissionResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author 孙一恒
 * @Date 2019/6/16 11:57
 * @Version 1.0
 **/
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * 获取一个用户的所有权限
     */
    @Query(value = "select new com.hitwh.shop.model.pojo.PermissionResult(p.urlPrefix) from User u, UserRole ur, Permission p, RolePermission rp, Role r" +
            " where u.id = :userId and u.id = ur.userId and ur.roleId = r.id and rp.roleId = r.id and rp.permissionId = p.id and u.deleted=0 and ur.deleted=0 and p.deleted=0 and rp.deleted=0")
    List<PermissionResult> getPermissionByUserId(@Param("userId") Integer userId);

    /**
     * 获取游客用户的权限
     */
    @Query(value = "select new com.hitwh.shop.model.pojo.PermissionResult(p.urlPrefix) from Permission p, RolePermission rp, Role r" +
            " where r.roleName='visitor' and rp.roleId = r.id and rp.permissionId = p.id and p.deleted=0 and rp.deleted=0")
    List<PermissionResult> getVisitorPermission();

    /**
     * 获取一个用户的所有角色
     */
    @Query(value = "select new com.hitwh.shop.model.entity.Role(r.id, r.roleName, r.state, r.deleted) from Role r, User u, UserRole ur where u.id = :userId and r.id = ur.roleId and u.id = ur.userId " +
            "and u.deleted = 0 and r.deleted = 0 and ur.deleted = 0")
    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
